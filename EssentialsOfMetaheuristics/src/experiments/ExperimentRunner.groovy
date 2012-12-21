package experiments

import problems.LeadingOnes
import problems.OnesMax
import singleStateMethods.HillClimber
import singleStateMethods.SteepestAscentHillClimber
import singleStateMethods.SteepestAscentHillClimberWithReplacement

class ExperimentRunner {
	
	static runExperiment(searchers, problems, numRuns = 30) {
		for (s in searchers) {
			for (p in problems) {
				for (i in 0..<30) {
					p.evalCount = 0
					def result = s.maximize(p)
					println "${s.toString()}\t${p.toString()}\t${p.quality(result)}"
				}
			}
		}
	}

	static main(args) {
		def searchers = [
			new HillClimber(),
			new SteepestAscentHillClimber(numGradientSamples : 1),
			new SteepestAscentHillClimber(numGradientSamples : 2),
			new SteepestAscentHillClimber(numGradientSamples : 4),
			new SteepestAscentHillClimberWithReplacement(numGradientSamples : 1),
			new SteepestAscentHillClimberWithReplacement(numGradientSamples : 2),
			new SteepestAscentHillClimberWithReplacement(numGradientSamples : 4),
		]
		def problems = [
			new OnesMax(numBits : 100, maxIterations : 250),
			new LeadingOnes(numBits : 100, maxIterations : 1000)
		]
		// It would be nice to collect the total time here and include it in the
		// output.
		runExperiment(searchers, problems)
	}

}
