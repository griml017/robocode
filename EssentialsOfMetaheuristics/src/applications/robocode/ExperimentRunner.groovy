package applications.robocode

import applications.robocode.BattleRunner
import applications.robocode.GunPower
import applications.robocode.RobotBuilder
import problems.HIFF
import problems.LeadingOnes
import problems.LeadingOnesBlocks
import problems.OnesMax
import problems.Trap
import singleStateMethods.HillClimber
import singleStateMethods.RandomSearch
import singleStateMethods.SteepestAscentHillClimber
import singleStateMethods.SteepestAscentHillClimberWithReplacement

class ExperimentRunner {
//Targeting and stopping after a kill
    static main(args) {
        Random random = new Random()
        def id
        def gunpower = new GunPower()
        gunpower.create()
        def robotBuilder = new RobotBuilder("templates/HappyRobot.template")
        def battleRunner = new BattleRunner("templates/battle.template")
        def randomSearch = new RandomSearch()
        Integer numRuns = 10
        def result
        for(int x=1; x<=numRuns; x++){
            id = random.nextInt(1000000)
            def values = ["id" : id, "gun_power" : gunpower.gunpower(), "randomNum": gunpower.randomNum]
            robotBuilder.buildJarFile(values)
            battleRunner.buildBattleFile(id)
            result = randomSearch.maximize(gunpower, battleRunner, robotBuilder, values)
            println "This is the best evolve variables for this round: " + result + " ---- with ID: " + values['id']
            values = ["id": id, "gun_power": result[0], "randomNum": result[1]]
            robotBuilder.buildJarFile(values)
            
        }
    }
}
