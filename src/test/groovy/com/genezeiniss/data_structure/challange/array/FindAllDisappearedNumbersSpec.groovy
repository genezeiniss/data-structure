package com.genezeiniss.data_structure.challange.array

import spock.lang.Specification
import spock.lang.Unroll

class FindAllDisappearedNumbersSpec extends Specification {


    @Unroll
    def "find disappeared numbers"() {
        when:
        def output = FindAllDisappearedNumbers.findDisappearedNumbers(input)

        then:
        assert output == expecedOutput

        where:
        input                    || expecedOutput
        [4, 3, 2, 7, 8, 2, 3, 1] || [5, 6]
        [1, 1]                   || [2]
        [1]                      || []
        [1, 1, 2, 2]             || [3, 4]
        [2, 2]                   || [1]
    }
}
