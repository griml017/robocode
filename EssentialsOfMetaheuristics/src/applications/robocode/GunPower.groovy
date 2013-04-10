package applications.robocode

class GunPower {
    protected rand = new java.util.Random()
    Integer evalCount = 0
    Integer maxIterations = 1000
    Double gunPower = 1.0
    def score = 0

    def create() {
        generateRandomPower(gunPower)
    }
    
    def random() {
        generateRandomPower(gunPower)
    }
    
    def gunpower() {
        gunPower
    }
    
    def tweak = {mutationRate = 1, randomPower = null ->
        randomPower = generateRandomPower(gunPower)
    }

    def generateRandomPower(Double gunPower) {
        gunPower = (rand.nextInt(300)+1)/10
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