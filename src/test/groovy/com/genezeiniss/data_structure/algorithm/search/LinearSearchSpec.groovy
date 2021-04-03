package com.genezeiniss.data_structure.algorithm.search

import com.github.javafaker.Faker
import spock.lang.Specification
import spock.lang.Unroll

class LinearSearchSpec extends Specification {

    Faker faker = new Faker()

    @Unroll
    def "search for number - #scenario"() {
        when:
        def targetIndex = LinearSearch.searchForNumber(list, target)

        then:
        assert targetIndex == expectedIndex

        where:
        scenario                                            | list                            | target || expectedIndex
        "list is sorted ascending; target is first element" | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 1      || 0
        "list is sorted ascending; target is last element"  | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 10     || 9
        "list is sorted ascending; target is the middle"    | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 5      || 4
        "list is sorted ascending; target is not included"  | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 11     || -1
        "list is not sorted; target included"               | [1, 2, 7, 4, 5, 6, 3, 8, 9, 10] | 3      || 6
        "list is empty"                                     | []                              | 1      || -1
    }

    def "search for string - #scenario"() {
        given: "list of full names"
        def names = []
        25.times {
            names.add(String.format("%s %s", faker.name().firstName(), faker.name().lastName()))
        }

        and: "target name with index 17"
        def target = "Gene Zeiniss"
        names.add(17, target)

        expect: "search for string expected to return index 17"
        def targetIndex = LinearSearch.searchForString(names, target)
        assert targetIndex == 17
    }
}
