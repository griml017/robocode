package applications.robocode

class GunPower {
    protected rand = new java.util.Random()
    Integer evalCount = 0
    Integer maxIterations = 1000
    Double gunPower

    def tweak = {mutationRate = 1, randomPower = null ->
        randomPower = generateRandomPower(gunPower)
    }

    def generateRandomPower(Double gunPower) {
        gunPower = (rand.nextInt(30)+1)/10
        return gunPower
    }

    def terminate = { a, q = quality(a) ->
        evalCount >= maxIterations || q == maximalQuality()
    }
    
    def quality() {
        true
    }

    String toString() {
        this.class.name.split("\\.")[-1] + "_" + gunPower + "_" + maxIterations
    }
}