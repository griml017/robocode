package applications.robocode

class GunPower {
    protected rand = new java.util.Random()
    Integer evalCount = 0
    Integer maxIterations = 10
    def gunPower = 1.0
    def score = 0

    def create() {
        gunPower = generateRandomPower()
    }
    
    def random() {
        gunPower = generateRandomPower()
        print "This is the gunpower: "+ gunPower + " The next line is the score..."
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