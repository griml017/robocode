package singleStateMethods

import applications.robocode.BattleRunner
import applications.robocode.RobotBuilder
import groovy.transform.ToString

class RandomSearch {
    
    def maximize(problem, BattleRunner battleRunner, RobotBuilder robotBuilder, values) {
        def s = [2]
        s[0] = problem.random()
        s[1] = problem.randomNum
        def changingValues = ["id": values['id'], "gun_power": s[0], "randomNum": s[1]]
        robotBuilder.buildJarFile(changingValues)
        def sQuality = battleRunner.runBattle(values['id'])
        
        while (!problem.terminate(s, sQuality)) {
            problem.evalCount ++
            def r = [2]
            r[0] = problem.random()
            r[1] = problem.randomNum
            changingValues = ["id": values['id'], "gun_power": r[0], "randomNum": r[1]]
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