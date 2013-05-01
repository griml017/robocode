package applications.robocode

class GunPower {
    protected rand = new java.util.Random()
    Integer evalCount = 0
    Integer maxIterations = 10
    def gunPower = 1.0
    def randomNum = 18.0
    def score = 0

    def create() {
        gunPower = generateRandomPower()
        randomNum = (rand.nextInt(1000)+1)/10
    }
    
    def random() {
        gunPower = generateRandomPower()
        randomNum = (rand.nextInt(1000)+1)/10
        print "This is the gunpower: "+ gunPower + "  and this is the randNum: " + randomNum + "  --"
        gunPower
    }
    
    def gunpower() {
        gunPower
    }
    
    def tweak = {mutationRate = 1, randomPower = null ->
        randomPower = generateRandomPower()
    }

    def generateRandomPower() {
         (rand.nextInt(300)+1)/100
    }

    def terminate = { a, q = quality(a) ->
        evalCount >= maxIterations
    }
    
    def quality() {
        score
    }

    String toString() {
        this.class.name.split("\\.")[-1] + "_" + gunPower + "_" + maxIterations
    }
}