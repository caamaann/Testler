package ca.ubc.salt.model.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Settings
{

    
    
    
    
    
    public final static Logger consoleLogger = LogManager.getRootLogger();
    // public final static Logger fileLogger =
    // LogManager.getLogger("FileLogger");
    public static final String LIBRARY_JAVA = "/Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre/lib/rt.jar";
    // public static final String LIBRARY_JAVA =
    // "/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/jre/lib/rt.jar";
    public static final String PROJECT_PATH = "/Users/arash/Research/repos/commons-math";
    // public static final String PROJECT_PATH =
    // "/Users/arash/Documents/workspace-mars/Calculator";
    public static final String PROJECT_INSTRUMENTED_PATH = PROJECT_PATH + "-instrumented";
    public static final String PROJECT_MERGED_PATH = PROJECT_PATH + "-merged";
    public static final String PROJECT_STOPWATCH_PATH = PROJECT_PATH + "-stopwatched";
    public final static String tracePaths = PROJECT_INSTRUMENTED_PATH + "/traces";
    public final static String classFileMappingPath = "classFileMapping.txt";

    public final static String[] methodBlackList = new String[] { "AdamsBashforthIntegratorTest.backward",
	    "AdamsNordsieckTransformerTest.testTransformExact", "AkimaSplineInterpolatorTest.testInterpolateCubic",
	    "AkimaSplineInterpolatorTest.testInterpolateLine", "AkimaSplineInterpolatorTest.testInterpolateParabola",
	    "ArithmeticUtilsTest.testSubAndCheckLong", "ArrayFieldVectorTest.testSerial",
	    "ArrayFieldVectorTest.testWalkInOptimizedOrderPreservingVisitor3",
	    "BiDiagonalTransformerTest.testVOrthogonal", "BicubicInterpolatingFunctionTest.testParaboloid",
	    "BicubicInterpolatingFunctionTest.testPlane", "BicubicInterpolatorTest.testParaboloid",
	    "BicubicInterpolatorTest.testPlane", "BlockFieldMatrixTest.testCopyFunctions",
	    "BlockFieldMatrixTest.testCopySubMatrix", "BlockFieldMatrixTest.testEqualsAndHashCode",
	    "BlockFieldMatrixTest.testGetSetColumnLarge", "BlockFieldMatrixTest.testGetSetColumnMatrixLarge",
	    "BlockFieldMatrixTest.testGetSetColumnVectorLarge", "BlockFieldMatrixTest.testGetSetMatrixLarge",
	    "BlockFieldMatrixTest.testGetSetRowLarge", "BlockFieldMatrixTest.testGetSetRowMatrixLarge",
	    "BlockFieldMatrixTest.testGetSetRowVectorLarge", "BlockFieldMatrixTest.testMath209",
	    "BlockFieldMatrixTest.testOperateLarge", "BlockFieldMatrixTest.testOperatePremultiplyLarge",
	    "BlockFieldMatrixTest.testSeveralBlocks", "BlockFieldMatrixTest.testToString",
	    "BlockFieldMatrixTest.testWalk", "BlockRealMatrixTest.testCopyFunctions",
	    "BlockRealMatrixTest.testGetSetMatrixLarge", "BlockRealMatrixTest.testMath209",
	    "BlockRealMatrixTest.testOperateLarge", "BlockRealMatrixTest.testOperatePremultiplyLarge",
	    "BlockRealMatrixTest.testToString", "CertifiedDataTest.testDescriptiveStatistics",
	    "CertifiedDataTest.testSummaryStatistics", "ClassicalRungeKuttaStepInterpolatorTest.derivativesConsistency",
	    "ClassicalRungeKuttaStepInterpolatorTest.serialization", "CombinationsTest.testLexicographicIterator",
	    "CombinatoricsUtilsTest.test0Choose0", "CombinatoricsUtilsTest.testBinomialCoefficientFail",
	    "CombinatoricsUtilsTest.testBinomialCoefficientLarge", "CombinatoricsUtilsTest.testCheckBinomial3",
	    "CombinatoricsUtilsTest.testFactorial", "ContinuedFractionTest.testGoldenRatio",
	    "ContinuousOutputFieldModelTest.testBoundaries", "ContinuousOutputFieldModelTest.testModelsMerging",
	    "ContinuousOutputFieldModelTest.testRandomAccess", "ContinuousOutputModelTest.testBoundaries",
	    "ContinuousOutputModelTest.testRandomAccess",
	    "CorrelatedRandomVectorGeneratorTest.testSampleWithZeroCovariance", "CovarianceTest.testLongly",
	    "CovarianceTest.testOneColumn", "DfpMathTest.testPow", "DfpMathTest.testSin",
	    "DormandPrince54StepInterpolatorTest.checkClone", "DormandPrince54StepInterpolatorTest.serialization",
	    "DormandPrince853StepInterpolatorTest.checklone", "DormandPrince853StepInterpolatorTest.serialization",
	    "EigenDecompositionTest.testBigMatrix", "EnumeratedIntegerDistributionTest.testSample",
	    "EnumeratedRealDistributionTest.testGetSupportLowerBound",
	    "EnumeratedRealDistributionTest.testIsSupportConnected", "EnumeratedRealDistributionTest.testSample",
	    "Euclidean2DTest.testDimension", "Euclidean2DTest.testSubSpace",
	    "EulerStepInterpolatorTest.interpolationInside", "EulerStepInterpolatorTest.serialization",
	    "EvaluationTest.testComputeValueAndJacobian", "EventFilterTest.testDecreasingOnly",
	    "EventFilterTest.testHistoryDecreasingBackward", "EventFilterTest.testHistoryDecreasingForward",
	    "EventFilterTest.testHistoryIncreasingBackward", "EventFilterTest.testHistoryIncreasingForward",
	    "EventFilterTest.testIncreasingOnly", "FastHadamardTransformerTest.testNoIntInverse",
	    "FieldMatrixImplTest.testWalk", "GillStepInterpolatorTest.serialization",
	    "GillStepInterpolatorTest.testDerivativesConsistency", "GraggBulirschStoerStepInterpolatorTest.checklone",
	    "GraggBulirschStoerStepInterpolatorTest.serialization", "HermiteTest.testNormalDistribution",
	    "HermiteTest.testNormalVariance", "HighamHall54StepInterpolatorTest.checkClone",
	    "HighamHall54StepInterpolatorTest.serialization", "KMeansPlusPlusClustererTest.testSmallDistances",
	    "KohonenTrainingTaskTest.testTravellerSalesmanSquareTourParallelSolver",
	    "KolmogorovSmirnovTestTest.testDRoundingMonteCarlo", "LegendreHighPrecisionTest.testCos",
	    "LegendreHighPrecisionTest.testInverse", "LocationFinderTest.test2x2Network",
	    "LutherStepInterpolatorTest.derivativesConsistency", "LutherStepInterpolatorTest.serialization",
	    "MannWhitneyUTestTest.testBigDataSetOverflow", "MidpointStepInterpolatorTest.serialization",
	    "MidpointStepInterpolatorTest.testDerivativesConsistency",
	    "MultivariateNormalDistributionTest.testSampling",
	    "MultivariateNormalMixtureModelDistributionTest.testNonUnitWeightSum",
	    "MultivariateSummaryStatisticsTest.testEqualsAndHashCode", "NaturalRankingTest.testNaNsAndInfs",
	    "NaturalRankingTest.testNaNsMaximalTiesMinimum", "NordsieckStepInterpolatorTest.derivativesConsistency",
	    "NordsieckStepInterpolatorTest.serialization", "OpenIntToDoubleHashMapTest.testConcurrentModification",
	    "OpenIntToDoubleHashMapTest.testContainsKey", "OpenIntToDoubleHashMapTest.testCopy",
	    "OpenIntToDoubleHashMapTest.testGetAbsent", "OpenIntToDoubleHashMapTest.testGetFromEmpty",
	    "OpenIntToDoubleHashMapTest.testIterator", "OpenIntToDoubleHashMapTest.testPutAbsentOnExisting",
	    "OpenIntToDoubleHashMapTest.testPutAndGet", "OpenIntToDoubleHashMapTest.testPutAndGetWith0ExpectedSize",
	    "OpenIntToDoubleHashMapTest.testPutAndGetWithExpectedSize",
	    "OpenIntToDoubleHashMapTest.testPutKeysWithCollisions", "OpenIntToDoubleHashMapTest.testPutOnExisting",
	    "OpenIntToDoubleHashMapTest.testRemove", "OpenIntToDoubleHashMapTest.testRemove2",
	    "OpenIntToDoubleHashMapTest.testRemoveAbsent", "OpenIntToFieldTest.testPutAndGetWithExpectedSize",
	    "PiecewiseBicubicSplineInterpolatingFunctionTest.testParabaloid",
	    "PiecewiseBicubicSplineInterpolatingFunctionTest.testPlane", "PolygonsSetTest.testIssue880Complete",
	    "PolyhedronsSetTest.testCross", "PolynomialCurveFitterTest.testRedundantSolvable",
	    "QRDecompositionTest.testAEqualQR", "QRDecompositionTest.testDimensions",
	    "QRDecompositionTest.testHTrapezoidal", "QRDecompositionTest.testInvertTallSkinny",
	    "QRDecompositionTest.testMatricesValues", "QRDecompositionTest.testQOrthogonal",
	    "QRDecompositionTest.testRUpperTriangular", "QRSolverTest.testOverdetermined",
	    "QRSolverTest.testUnderdetermined", "RRQRDecompositionTest.testAPEqualQR",
	    "RRQRDecompositionTest.testDimensions", "RRQRDecompositionTest.testHTrapezoidal",
	    "RRQRDecompositionTest.testQOrthogonal", "RRQRDecompositionTest.testRUpperTriangular",
	    "RRQRDecompositionTest.testRank", "RRQRSolverTest.testOverdetermined", "RRQRSolverTest.testUnderdetermined",
	    "SimplexSolverTest.testLargeModel", "SimplexSolverTest.testMath930",
	    "SingularValueDecompositionTest.testAEqualUSVt", "SingularValueDecompositionTest.testStability1",
	    "SingularValueDecompositionTest.testStability2", "SphericalPolygonsSetTest.testConcentricSubParts",
	    "SplineInterpolatorTest.testInterpolateLinearDegenerateThreeSegment",
	    "ThreeEighthesStepInterpolatorTest.derivativesConsistency",
	    "ThreeEighthesStepInterpolatorTest.serialization", "TrapezoidIntegratorTest.testQuinticFunction",
	    "TriDiagonalTransformerTest.testMatricesValues3", "TriDiagonalTransformerTest.testMatricesValues5",
	    "TricubicInterpolatingFunctionTest.testPlane", "TricubicInterpolatingFunctionTest.testQuadric",
	    "TricubicInterpolatingFunctionTest.testWave", "UniformCrossoverTest.testCrossover",
	    "ValueServerTest.testFixedSeed", "ValueServerTest.testNextDigest",
	    "EulerStepInterpolatorTest.derivativesConsistency", "BetaDistributionTest.testMomentsSampling",
	    "EulerStepInterpolatorTest.noReset", "DummyStepInterpolatorTest.testNoReset", "DfpDecTest.testNextAfter",
	    "UniformCrossoverTest.testCrossoverDimensionMismatchException", "RandomDataGeneratorTest.testNextZipf",
	    "OpenMapRealMatrixTest.testMath870", "SparseRealMatrixTest.testGetRowVector",
	    "KMeansPlusPlusClustererTest.testPerformClusterAnalysisToManyClusters",
	    "MultivariateNormalMixtureModelDistributionTest.testPreconditionPositiveWeights",
	    "BlockRealMatrixTest.testWalk", "BlockFieldMatrixTest.testGetRowVector",
	    "RectangularCholeskyDecompositionTest.testFullRank", "BicubicInterpolatorTest.testPreconditions",
	    "HermiteTest.testNormalMean", "SphericalPolygonsSetTest.testFullSphere", "FieldMatrixImplTest.testTrace",
	    "AkimaSplineInterpolatorTest.testIllegalArguments", "BlockFieldMatrixTest.testSetRowMatrix",
	    "DormandPrince54StepInterpolatorTest.derivativesConsistency", "BlockFieldMatrixTest.testAddFail",
	    "EnumeratedRealDistributionTest.testIssue942", "BlockFieldMatrixTest.testTrace",
	    "SingularValueDecompositionTest.testConditionNumber", "NeuronSquareMesh2DTest.test3x3TorusNetwork2",
	    "FieldLUDecompositionTest.testPAEqualLU", "CorrelatedRandomVectorGeneratorTest.testMeanAndCovariance",
	    "BlockFieldMatrixTest.testDimensions", "QRDecompositionTest.testQRSingular",
	    "MultivariateNormalDistributionTest.testDensities", "GaussIntegratorTest.testGetWeights",
	    "ArrayFieldVectorTest.testWalkInOptimizedOrderPreservingVisitor2",
	    "ClassicalRungeKuttaIntegratorTest.testStepSize", "MidpointIntegratorTest.testStepSize",
	    "QRDecompositionTest.testInvertShortWide", "EigenDecompositionTest.testMathpbx03",
	    "EvaluationTest.testLazyEvaluation", "RRQRSolverTest.testSolveDimensionErrors",
	    "BlockFieldMatrixTest.testGetRow", "JacobianFunctionTest.testSphere",
	    "AdamsNordsieckTransformerTest.testPolynomialRegular", "GillIntegratorTest.testStepSize",
	    "DormandPrince853StepInterpolatorTest.derivativesConsistency", "RRQRDecompositionTest.testNonInvertible",
	    "HighamHall54StepInterpolatorTest.derivativesConsistency", "BlockRealMatrixTest.testPremultiplyVector",
	    "PolygonsSetTest.testHole", "QRSolverTest.testSolveDimensionErrors", "Euclidean2DTest.testSerialization",
	    "PolynomialCurveFitterTest.testSmallError", "PolyhedronsSetTest.testBox",
	    "ThreeEighthesIntegratorTest.testStepSize", "ContinuousOutputModelTest.testModelsMerging",
	    "EventFilterTest.testTwoOppositeFilters", "TriDiagonalTransformerTest.testQOrthogonal",
	    "PrimesTest.testNextPrime", "BlockFieldMatrixTest.testGetSubMatrix",
	    "AdamsBashforthIntegratorTest.testIncreasingTolerance",
	    "MultivariateNormalMixtureExpectationMaximizationTest.testMaxIterationsPositive",
	    "BlockFieldMatrixTest.testGetVectors", "ContinuousOutputFieldModelTest.testErrorConditions",
	    "JacobianMatricesTest.testFinalResult", "BiDiagonalTransformerTest.testAEqualUSVt",
	    "GraggBulirschStoerStepInterpolatorTest.derivativesConsistency", "BlockRealMatrixTest.testGetSubMatrix",
	    "NevilleInterpolatorTest.testExpm1Function", "TrapezoidIntegratorTest.testSinFunction",
	    "LutherIntegratorTest.testStepSize", "PiecewiseBicubicSplineInterpolatingFunctionTest.testPreconditions",
	    "CorrelatedRandomVectorGeneratorTest.testRootMatrix", "BicubicInterpolatingFunctionTest.testPreconditions",
	    "BlockFieldMatrixTest.testPremultiplyVector", "HaltonSequenceGeneratorTest.testConstructor",
	    "SimplexSolverTest.testMath828Cycle", "NaturalRankingTest.testDefault",
	    "ValueServerTest.testNextDigestFail", "OpenIntToDoubleHashMapTest.testPutKeysWithCollision2",
	    "CovarianceTest.testConsistency", "MultidimensionalCounterTest.testIterator",
	    "GammaTest.testGammaNegativeInteger", "ThreeEighthesIntegratorTest.testKepler",
	    "EulerIntegratorTest.testStepSize", "BicubicInterpolatingFunctionTest.testIsValidPoint",
	    "MultidimensionalCounterTest.testPreconditions", "ValueServerTest.testEmptyReplayFile",
	    "MultivariateSummaryStatisticsTest.testSetterIllegalState", "GammaTest.testRegularizedGammaPositiveZero",
	    "NaturalRankingTest.testNaNsMinimalTiesMaximum", "CovarianceTest.testConstant",
	    "TricubicInterpolatingFunctionTest.testPreconditions",
	    "BetaDistributionTest.testMomentsSampling", "EulerStepInterpolatorTest.noReset",
	    "KolmogorovSmirnovTestTest.testDRoundingMonteCarlo", "OpenIntToFieldTest.testPutAndGetWithExpectedSize",
	    "UniformCrossoverTest.testCrossoverDimensionMismatchException", "SparseRealMatrixTest.testGetRowVector",
	    "ContinuedFractionTest.testGoldenRatio",
	    "MultivariateNormalMixtureModelDistributionTest.testPreconditionPositiveWeights",
	    "MultivariateNormalMixtureModelDistributionTest.testSampling", "BlockFieldMatrixTest.testGetRowVector",
	    "OpenIntToDoubleHashMapTest.testPutAndGetWith0ExpectedSize", "ArithmeticUtilsTest.testSubAndCheckLong",
	    "SphericalPolygonsSetTest.testFullSphere", "DfpDecTest.testRoundDecimal10",
	    "OpenIntToDoubleHashMapTest.testPutAndGetWithExpectedSize", "BlockFieldMatrixTest.testSetRowMatrix",
	    "BlockFieldMatrixTest.testMath209", "DormandPrince54StepInterpolatorTest.derivativesConsistency",
	    "SingularValueDecompositionTest.testDimensions", "TrapezoidIntegratorTest.testParameters",
	    "ThreeEighthesStepInterpolatorTest.derivativesConsistency",
	    "NordsieckStepInterpolatorTest.derivativesConsistency",
	    "OpenIntToDoubleHashMapTest.testPutKeysWithCollisions", "HermiteTest.testNormalDistribution",
	    "BlockFieldMatrixTest.testDimensions", "ValueServerTest.testReplay",
	    "ArrayFieldVectorTest.testWalkInOptimizedOrderPreservingVisitor2",
	    "QRDecompositionTest.testInvertShortWide",
	    "ArrayFieldVectorTest.testWalkInOptimizedOrderPreservingVisitor1", "EvaluationTest.testLazyEvaluation",
	    "RRQRSolverTest.testSolveDimensionErrors", "TournamentSelectionTest.testSelect",
	    "RectangularCholeskyDecompositionTest.testDecomposition3x3", "BetaDistributionTest.testDensity",
	    "BlockFieldMatrixTest.testGetRow", "BlockFieldMatrixTest.testMultiply",
	    "RRQRDecompositionTest.testNonInvertible", "QRDecompositionTest.testInvertTallSkinny",
	    "HighamHall54StepInterpolatorTest.derivativesConsistency", "DummyStepInterpolatorTest.testFixedState",
	    "CombinatoricsUtilsTest.testBinomialCoefficientFail", "BlockRealMatrixTest.testPremultiplyVector",
	    "TriDiagonalTransformerTest.testMatricesValues3", "Euclidean2DTest.testSerialization",
	    "EnumeratedRealDistributionTest.testGetSupportLowerBound", "OpenIntToDoubleHashMapTest.testGetFromEmpty",
	    "GillIntegratorTest.testKepler", "MannWhitneyUTestTest.testBigDataSetOverflow",
	    "BlockFieldMatrixTest.testMultiply2", "GraggBulirschStoerIntegratorTest.testTooLargeFirstStep",
	    "TriDiagonalTransformerTest.testQOrthogonal", "ContinuousOutputModelTest.testErrorConditions",
	    "HaltonSequenceGeneratorTest.test3DReference", "OpenIntToDoubleHashMapTest.testRemove2",
	    "BlockFieldMatrixTest.testGetSubMatrix", "BlockFieldMatrixTest.testSetSubMatrix",
	    "NaturalRankingTest.testNaNsMaximalTiesMinimum", "OpenIntToDoubleHashMapTest.testRemove",
	    "BlockFieldMatrixTest.testGetVectors", "RRQRDecompositionTest.testRank",
	    "BiDiagonalTransformerTest.testAEqualUSVt", "GraggBulirschStoerStepInterpolatorTest.derivativesConsistency",
	    "BlockRealMatrixTest.testGetSubMatrix", "NevilleInterpolatorTest.testExpm1Function",
	    "BiDiagonalTransformerTest.testDimensions", "LutherIntegratorTest.testStepSize",
	    "PolyhedronsSetTest.testOrientation", "PiecewiseBicubicSplineInterpolatingFunctionTest.testPreconditions",
	    "OpenIntToDoubleHashMapTest.testContainsKey", "OpenIntToDoubleHashMapTest.testPutOnExisting",
	    "HighamHall54StepInterpolatorTest.checkClone", "BlockFieldMatrixTest.testGetEntry",
	    "EventFilterTest.testDecreasingOnly", "BlockFieldMatrixTest.testPremultiplyVector",
	    "TrapezoidIntegratorTest.testQuinticFunction",
	    "MultivariateNormalMixtureExpectationMaximizationTest.testInitialMixture",
	    "EulerStepInterpolatorTest.derivativesConsistency", "CombinatoricsUtilsTest.testFactorial",
	    "DummyStepInterpolatorTest.testNoReset", "MidpointIntegratorTest.testBigStep", "DfpDecTest.testNextAfter",
	    "DormandPrince853IntegratorTest.testEventsScheduling", "RandomDataGeneratorTest.testNextZipf",
	    "OpenMapRealMatrixTest.testMath870", "EulerStepInterpolatorTest.interpolationInside",
	    "KMeansPlusPlusClustererTest.testPerformClusterAnalysisToManyClusters",
	    "CombinatoricsUtilsTest.testCheckBinomial3", "BlockRealMatrixTest.testWalk",
	    "RectangularCholeskyDecompositionTest.testFullRank", "ClassicalRungeKuttaIntegratorTest.testSanityChecks",
	    "BicubicInterpolatorTest.testPreconditions", "HermiteTest.testNormalMean",
	    "LegendreHighPrecisionTest.testCos", "FieldMatrixImplTest.testTrace",
	    "TriDiagonalTransformerTest.testNoAccessBelowDiagonal", "NeuronSquareMesh2DTest.testIterator",
	    "HighamHall54IntegratorTest.testSanityChecks", "AkimaSplineInterpolatorTest.testIllegalArguments",
	    "LutherIntegratorTest.testSanityChecks", "FieldMatrixImplTest.testPower",
	    "OpenIntToDoubleHashMapTest.testRemoveAbsent", "SparseRealMatrixTest.testSetSubMatrix",
	    "BlockFieldMatrixTest.testAddFail", "EnumeratedRealDistributionTest.testIssue942",
	    "GillStepInterpolatorTest.testDerivativesConsistency", "BlockFieldMatrixTest.testTrace",
	    "SingularValueDecompositionTest.testConditionNumber", "BlockRealMatrixTest.testNorm",
	    "CorrelatedRandomVectorGeneratorTest.testRank", "DormandPrince54IntegratorTest.testIncreasingTolerance",
	    "NeuronSquareMesh2DTest.test3x3TorusNetwork2", "FieldLUDecompositionTest.testPAEqualLU",
	    "FastHadamardTransformerTest.testNoIntInverse", "CorrelatedRandomVectorGeneratorTest.testMeanAndCovariance",
	    "OpenIntToDoubleHashMapTest.testIterator", "CombinatoricsUtilsTest.testBinomialCoefficientLarge",
	    "LocationFinderTest.test2x2Network", "ClassicalRungeKuttaStepInterpolatorTest.derivativesConsistency",
	    "BlockFieldMatrixTest.testScalarAdd", "QRDecompositionTest.testQRSingular",
	    "CorrelatedRandomVectorGeneratorTest.testMath226", "OpenIntToDoubleHashMapTest.testGetAbsent",
	    "MultivariateNormalDistributionTest.testDensities", "OpenIntToDoubleHashMapTest.testCopy",
	    "GaussIntegratorTest.testGetWeights", "ClassicalRungeKuttaIntegratorTest.testStepSize",
	    "MidpointIntegratorTest.testStepSize", "DiskGeneratorTest.testRandom",
	    "EigenDecompositionTest.testMathpbx03", "EulerStepInterpolatorTest.interpolationAtBounds",
	    "JacobianFunctionTest.testSphere", "GillIntegratorTest.testStepSize",
	    "DormandPrince853StepInterpolatorTest.derivativesConsistency", "NaturalRankingTest.testNaNsAndInfs",
	    "PolygonsSetTest.testHole", "QRSolverTest.testSolveDimensionErrors",
	    "PolynomialCurveFitterTest.testSmallError", "EventFilterTest.testIncreasingOnly",
	    "ThreeEighthesIntegratorTest.testStepSize", "ContinuousOutputModelTest.testModelsMerging",
	    "EventFilterTest.testTwoOppositeFilters", "OpenIntToDoubleHashMapTest.testConcurrentModification",
	    "PrimesTest.testNextPrime", "PrimesTest.testIsPrime", "OpenIntToDoubleHashMapTest.testPutAndGet",
	    "GraggBulirschStoerStepInterpolatorTest.checklone", "CovarianceTest.testLongly",
	    "QRDecompositionTest.testMatricesValues",
	    "MultivariateNormalMixtureExpectationMaximizationTest.testMaxIterationsPositive",
	    "BlockRealMatrixTest.testGetSetRowLarge", "ThreeEighthesIntegratorTest.testBigStep",
	    "FieldLUDecompositionTest.testLLowerTriangular", "DormandPrince54StepInterpolatorTest.checkClone",
	    "DormandPrince853StepInterpolatorTest.checklone", "LutherStepInterpolatorTest.derivativesConsistency",
	    "SplineInterpolatorTest.testInterpolateLinear", "PolynomialCurveFitterTest.testFit",
	    "QRSolverTest.testSolveRankErrors", "CombinationsTest.testLexicographicIterator",
	    "GradientFunctionTest.test2DDistance", "BicubicInterpolatingFunctionTest.testPreconditions",
	    "CorrelatedRandomVectorGeneratorTest.testRootMatrix", "SingularValueDecompositionTest.testAEqualUSVt",
	    "RandomDataGeneratorTest.testNextBeta", "MidpointStepInterpolatorTest.testDerivativesConsistency",
	    "HaltonSequenceGeneratorTest.testConstructor", "OpenIntToDoubleHashMapTest.testPutAbsentOnExisting",
	    "CombinatoricsUtilsTest.test0Choose0", "DormandPrince54IntegratorTest.testSmallLastStep",
	    "GillIntegratorTest.testSmallStep", "ClassicalRungeKuttaIntegratorTest.testMissedEndEvent",
	    "ClassicalRungeKuttaIntegratorTest.testTooLargeFirstStep" };
    public static final Set<String> blackListSet = new HashSet<String>(Arrays.asList(methodBlackList));

    public static final String TEST_CLASS = "/Users/arash/Research/repos/commons-math/src/test/java/org/apache/commons/math4/transform/FastFourierTransformerTest.java";
    public static final String PROD_TEST_CLASS = "/Users/Arash/Research/repos/commons-math/src/main/java/org/apache/commons/math4/complex/Complex.java";
    // public static final String TEST_CLASS =
    // "/Users/Arash/Research/repos/commons-math/src/test/java/org/apache/commons/math4/fraction/FractionTest.java";

    public static String getInstrumentedCodePath(String oldPath)
    {
	return oldPath.replaceFirst(PROJECT_PATH, PROJECT_INSTRUMENTED_PATH);
    }
    
    public static String getTimedCodePath(String oldPath)
    {
	return oldPath.replaceFirst(PROJECT_PATH, PROJECT_STOPWATCH_PATH);
    }

}
