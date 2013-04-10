package experiments

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

    static main(args) {
        Random random = new Random()
        def id = random.nextInt(1000000)
        def gunpower = new GunPower()
        def robotBuilder = new RobotBuilder("templates/HappyRobot.template")
        def battleRunner = new BattleRunner("templates/battle.template")
        def randomSearch = new RandomSearch()
        Integer numRuns = 30
        def values = ["id" : id, "gun_power" : gunpower.gunpower()]
        def result
        robotBuilder.buildJarFile(values)
        battleRunner.buildBattleFile(id)
        for(int x=1; x<=numRuns; x++){
            result = randomSearch.maximize(gunpower, battleRunner, id)problemproblem
            println "${randomSearch.toString()}\t${gunpower.toString()}\t${gunpower.quality(result)}"
        }
    }
}
