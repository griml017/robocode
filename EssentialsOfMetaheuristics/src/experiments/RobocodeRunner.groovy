package experiments

import applications.robocode.BattleRunner
import applications.robocode.RobotBuilder

class RobocodeRunner {
    def iterations = 1000
    
    def robotBuilder = new RobotBuilder("templates/HappyRobot.template")
    def battleRunner = new BattleRunner("templates/battle.template")
    def values = ["id" : id, "enemy_energy" : enemy_energy, "my_energy" : my_energy, "angle_diff" : angle_diff, "distance" : distance]
    
    
}
