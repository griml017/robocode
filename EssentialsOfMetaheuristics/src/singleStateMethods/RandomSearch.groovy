package singleStateMethods

import applications.robocode.BattleRunner
import groovy.transform.ToString

class RandomSearch {
    def maximize(problem, BattleRunner battleRunner, id) {
        def s = problem.random()
        problem.score = battleRunner.runBattle(id)
        def sQuality = problem.score
        
        while (!problem.terminate(s, sQuality)) {
            def r = problem.random()
            problem.score = battleRunner.runBattle(id)
            def rQuality = problem.score
            if (rQuality > sQuality) {
                s = r
                sQuality = rQuality
            }
        }
        
        return s
    }
    String toString() {
        "RS"
    }
}