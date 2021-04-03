package com.genezeiniss.data_structure.algorithm.sort

import com.github.javafaker.Faker
import spock.lang.Specification
import spock.lang.Unroll

class QuickSortSpec extends Specification {

    Faker faker = new Faker()

    @Unroll
    def "sort numbers in ascending order"() {
        when: "sort numbers method is called"
        def sortedList = QuickSort.sortNumbers(unsortedList)

        then: "sorted list size expected to be equal to unsorted list"
        if (sortedList != null)
            assert sortedList.size() == unsortedList.size()

        and: "list expected to be sorted as expected"
        assert sortedList == expectedSortedList

        where:
        scenario                | unsortedList           || expectedSortedList
        "list is null"          | null                   || null
        "list is empty"         | []                     || []
        "list has one value"    | [1]                    || [1]
        "unsorted list"         | [8, 5, 2, 1, 4, 3, 10] || [1, 2, 3, 4, 5, 8, 10]
        "list hase same values" | [5, 3, 6, 6, 8, 1, 4]  || [1, 3, 4, 5, 6, 6, 8]
    }

    def "sort strings"() {
        given: "list of full names"
        def names = []
        25.times {
            names.add(String.format("%s %s", faker.name().firstName(), faker.name().lastName()))
        }

        and: "name that expected to be placed at the top of sorted list"
        def topName = "Aaron Aaronov"
        def secondName = "Aaron Abramovich"
        def bottomName = "Zuri Zurinov"

        names.add(15, topName)
        names.add(20, bottomName)
        names.add(21, secondName)

        when: "sort strings method is called"
        def sortedList = QuickSort.sortString(names)

        then: "sorted list size expected to be equal to 28 (original 25 names + three addons)"
        assert sortedList.size() == 28

        and: "names list expected to be sorted as expected"
        assert sortedList[0] == topName
        assert sortedList[1] == secondName
        assert sortedList[27] == bottomName
    }
}
