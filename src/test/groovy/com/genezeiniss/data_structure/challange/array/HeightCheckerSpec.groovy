package com.genezeiniss.data_structure.challange.array

import spock.lang.Specification
import spock.lang.Unroll

class HeightCheckerSpec extends Specification {

    @Unroll
    def "height checker"() {
        when:
        def mismatches = HeightChecker.heightChecker(input)

        then:
        assert mismatches == expectedMismatches

        where:
        input              || expectedMismatches
        [1, 1, 4, 2, 1, 3] || 3
        [5, 1, 2, 3, 4]    || 5
        [1, 2, 3, 4, 5]    || 0
    }
}
