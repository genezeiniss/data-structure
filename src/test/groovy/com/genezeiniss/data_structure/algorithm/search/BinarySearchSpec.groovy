package com.genezeiniss.data_structure.algorithm.search

import com.github.javafaker.Faker
import spock.lang.Specification
import spock.lang.Unroll

class BinarySearchSpec extends Specification {

    Faker faker = new Faker()

    @Unroll
    def "iterative search for number - #scenario"() {
        when:
        def targetIndex = BinarySearch.iterativeSearchForNumber(list, target)

        then:
        assert targetIndex == expectedIndex

        where:
        scenario                                                                                 | list                            | target || expectedIndex
        "list is sorted ascending; target is first element"                                      | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 1      || 0
        "list is sorted ascending; target is last element"                                       | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 10     || 9
        "list is sorted ascending; target is the middle"                                         | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 5      || 4
        "list is sorted ascending; target is not included"                                       | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 11     || -1
        "list is not sorted; target included - expected index is -1, since list must be sorted!" | [1, 2, 7, 4, 5, 6, 3, 8, 9, 10] | 3      || -1
        "list is empty; "                                                                        | []                              | 1      || -1
    }

    def "iterative search for string - #scenario"() {
        given: "list of full names"
        def names = []
        25.times {
            names.add(String.format("%s %s", faker.name().firstName(), faker.name().lastName()))
        }

        and: "add target name to the list"
        def target = "Gene Zeiniss"
        names.add(target)

        and: "names list is sorted"
        names = names.sort()

        when: "iterative search for string is called on sorted list"
        def targetIndex = BinarySearch.iterativeSearchForString(names as List<String>, target)

        then: "target name index expected to be returned"
        assert names[targetIndex] == target
    }

    @Unroll
    def "recursive search for number - #scenario"() {
        when:
        def includedInList = BinarySearch.recursiveSearchForNumber(list, target)

        then:
        assert includedInList == expectedResult

        where:
        scenario                                                                                     | list                            | target || expectedResult
        "list is sorted ascending; target is first element"                                          | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 1      || true
        "list is sorted ascending; target is last element"                                           | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 10     || true
        "list is sorted ascending; target is the middle"                                             | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 5      || true
        "list is sorted ascending; target is not included"                                           | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] | 11     || false
        "list is not sorted; target included - expected result is false, since list must be sorted!" | [1, 2, 7, 4, 5, 6, 3, 8, 9, 10] | 3      || false
        "list is empty; "                                                                            | []                              | 1      || false
    }
}
