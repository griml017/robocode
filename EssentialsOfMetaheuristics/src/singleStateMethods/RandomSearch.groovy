package singleStateMethods

import applications.robocode.BattleRunner
import applications.robocode.RobotBuilder
import groovy.transform.ToString

class RandomSearch {
    
    def maximize(problem, BattleRunner battleRunner, RobotBuilder robotBuilder, values) {
        def s = problem.random()
        def changingValues = ["id": values['id'], "gun_power": s]
        robotBuilder.buildJarFile(changingValues)
        def sQuality = battleRunner.runBattle(values['id'])
        
        while (!problem.terminate(s, sQuality)) {
            problem.evalCount ++
            def r = problem.random()
            changingValues = ["id": values['id'], "gun_power": r]
            robotBuilder.buildJarFile(changingValues)
            def rQuality = battleRunner.runBattle(values['id'])
            if (rQuality > sQuality) {
                s = r
                sQuality = rQuality
            }
        }
        
        problem.evalCount = 0
        return s
    }
    String toString() {
        "RS"
    }
}