package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 7;
    static boolean[] flags = new boolean[3];

    static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.mLeft.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
            constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
            constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
            linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, i);
            linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, width);
            constraintWidget.mHorizontalResolution = 2;
            constraintWidget.setHorizontalDimension(i, width);
        }
        if (constraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i2 = constraintWidget.mTop.mMargin;
            int height = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
            constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
            constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, i2);
            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, height);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + i2);
            }
            constraintWidget.mVerticalResolution = 2;
            constraintWidget.setVerticalDimension(i2, height);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x003e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean optimizableMatchConstraint(androidx.constraintlayout.solver.widgets.ConstraintWidget r4, int r5) {
        /*
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r4.mListDimensionBehaviors
            r0 = r0[r5]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r2 = 0
            if (r0 == r1) goto L_0x000a
            return r2
        L_0x000a:
            float r0 = r4.mDimensionRatio
            r1 = 0
            r3 = 1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0020
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r4.mListDimensionBehaviors
            if (r5 != 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r3 = 0
        L_0x0018:
            r4 = r4[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x001f
            return r2
        L_0x001f:
            return r2
        L_0x0020:
            if (r5 != 0) goto L_0x0030
            int r5 = r4.mMatchConstraintDefaultWidth
            if (r5 == 0) goto L_0x0027
            return r2
        L_0x0027:
            int r5 = r4.mMatchConstraintMinWidth
            if (r5 != 0) goto L_0x002f
            int r4 = r4.mMatchConstraintMaxWidth
            if (r4 == 0) goto L_0x003e
        L_0x002f:
            return r2
        L_0x0030:
            int r5 = r4.mMatchConstraintDefaultHeight
            if (r5 == 0) goto L_0x0035
            return r2
        L_0x0035:
            int r5 = r4.mMatchConstraintMinHeight
            if (r5 != 0) goto L_0x003f
            int r4 = r4.mMatchConstraintMaxHeight
            if (r4 == 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            return r3
        L_0x003f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Optimizer.optimizableMatchConstraint(androidx.constraintlayout.solver.widgets.ConstraintWidget, int):boolean");
    }

    static void analyze(int i, ConstraintWidget constraintWidget) {
        ConstraintWidget constraintWidget2 = constraintWidget;
        constraintWidget.updateResolutionNodes();
        ResolutionAnchor resolutionNode = constraintWidget2.mLeft.getResolutionNode();
        ResolutionAnchor resolutionNode2 = constraintWidget2.mTop.getResolutionNode();
        ResolutionAnchor resolutionNode3 = constraintWidget2.mRight.getResolutionNode();
        ResolutionAnchor resolutionNode4 = constraintWidget2.mBottom.getResolutionNode();
        boolean z = (i & 8) == 8;
        boolean z2 = constraintWidget2.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget2, 0);
        if (!(resolutionNode.type == 4 || resolutionNode3.type == 4)) {
            if (constraintWidget2.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || (z2 && constraintWidget.getVisibility() == 8)) {
                if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintWidget2.mLeft.mTarget != null && constraintWidget2.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget != null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    if (z) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    }
                } else if (!(constraintWidget2.mLeft.mTarget == null || constraintWidget2.mRight.mTarget == null)) {
                    resolutionNode.setType(2);
                    resolutionNode3.setType(2);
                    if (z) {
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                        resolutionNode.setOpposite(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                        resolutionNode3.setOpposite(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.setOpposite(resolutionNode3, (float) (-constraintWidget.getWidth()));
                        resolutionNode3.setOpposite(resolutionNode, (float) constraintWidget.getWidth());
                    }
                }
            } else if (z2) {
                int width = constraintWidget.getWidth();
                resolutionNode.setType(1);
                resolutionNode3.setType(1);
                if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget == null) {
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, width);
                    }
                } else if (constraintWidget2.mLeft.mTarget == null || constraintWidget2.mRight.mTarget != null) {
                    if (constraintWidget2.mLeft.mTarget != null || constraintWidget2.mRight.mTarget == null) {
                        if (!(constraintWidget2.mLeft.mTarget == null || constraintWidget2.mRight.mTarget == null)) {
                            if (z) {
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                            }
                            if (constraintWidget2.mDimensionRatio == 0.0f) {
                                resolutionNode.setType(3);
                                resolutionNode3.setType(3);
                                resolutionNode.setOpposite(resolutionNode3, 0.0f);
                                resolutionNode3.setOpposite(resolutionNode, 0.0f);
                            } else {
                                resolutionNode.setType(2);
                                resolutionNode3.setType(2);
                                resolutionNode.setOpposite(resolutionNode3, (float) (-width));
                                resolutionNode3.setOpposite(resolutionNode, (float) width);
                                constraintWidget2.setWidth(width);
                            }
                        }
                    } else if (z) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -width);
                    }
                } else if (z) {
                    resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                } else {
                    resolutionNode3.dependsOn(resolutionNode, width);
                }
            }
        }
        boolean z3 = constraintWidget2.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget2, 1);
        if (resolutionNode2.type != 4 && resolutionNode4.type != 4) {
            if (constraintWidget2.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || (z3 && constraintWidget.getVisibility() == 8)) {
                if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget == null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaseline.mTarget != null) {
                        constraintWidget2.mBaseline.getResolutionNode().setType(1);
                        resolutionNode2.dependsOn(1, constraintWidget2.mBaseline.getResolutionNode(), -constraintWidget2.mBaselineDistance);
                    }
                } else if (constraintWidget2.mTop.mTarget != null && constraintWidget2.mBottom.mTarget == null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaselineDistance > 0) {
                        constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                    }
                } else if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget != null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaselineDistance > 0) {
                        constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                    }
                } else if (constraintWidget2.mTop.mTarget != null && constraintWidget2.mBottom.mTarget != null) {
                    resolutionNode2.setType(2);
                    resolutionNode4.setType(2);
                    if (z) {
                        resolutionNode2.setOpposite(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                        resolutionNode4.setOpposite(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                        constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                    } else {
                        resolutionNode2.setOpposite(resolutionNode4, (float) (-constraintWidget.getHeight()));
                        resolutionNode4.setOpposite(resolutionNode2, (float) constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaselineDistance > 0) {
                        constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                    }
                }
            } else if (z3) {
                int height = constraintWidget.getHeight();
                resolutionNode2.setType(1);
                resolutionNode4.setType(1);
                if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget == null) {
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, height);
                    }
                } else if (constraintWidget2.mTop.mTarget == null || constraintWidget2.mBottom.mTarget != null) {
                    if (constraintWidget2.mTop.mTarget != null || constraintWidget2.mBottom.mTarget == null) {
                        if (constraintWidget2.mTop.mTarget != null && constraintWidget2.mBottom.mTarget != null) {
                            if (z) {
                                constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                            }
                            if (constraintWidget2.mDimensionRatio == 0.0f) {
                                resolutionNode2.setType(3);
                                resolutionNode4.setType(3);
                                resolutionNode2.setOpposite(resolutionNode4, 0.0f);
                                resolutionNode4.setOpposite(resolutionNode2, 0.0f);
                                return;
                            }
                            resolutionNode2.setType(2);
                            resolutionNode4.setType(2);
                            resolutionNode2.setOpposite(resolutionNode4, (float) (-height));
                            resolutionNode4.setOpposite(resolutionNode2, (float) height);
                            constraintWidget2.setHeight(height);
                            if (constraintWidget2.mBaselineDistance > 0) {
                                constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                            }
                        }
                    } else if (z) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -height);
                    }
                } else if (z) {
                    resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                } else {
                    resolutionNode4.dependsOn(resolutionNode2, height);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (r7.mHorizontalChainStyle == 2) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        if (r7.mVerticalChainStyle == 2) goto L_0x0034;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean applyChainOptimized(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r22, androidx.constraintlayout.solver.LinearSystem r23, int r24, int r25, androidx.constraintlayout.solver.widgets.ChainHead r26) {
        /*
            r0 = r23
            r1 = r24
            r2 = r26
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r2.mFirst
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r2.mLast
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r2.mFirstVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r2.mLastVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r2.mHead
            float r8 = r2.mTotalWeight
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r2.mFirstMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mLastMatchConstraintWidget
            r9 = r22
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r9.mListDimensionBehaviors
            r2 = r2[r1]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r2 = 2
            r10 = 1
            if (r1 != 0) goto L_0x0038
            int r11 = r7.mHorizontalChainStyle
            if (r11 != 0) goto L_0x0028
            r11 = 1
            goto L_0x0029
        L_0x0028:
            r11 = 0
        L_0x0029:
            int r12 = r7.mHorizontalChainStyle
            if (r12 != r10) goto L_0x002f
            r12 = 1
            goto L_0x0030
        L_0x002f:
            r12 = 0
        L_0x0030:
            int r7 = r7.mHorizontalChainStyle
            if (r7 != r2) goto L_0x0036
        L_0x0034:
            r2 = 1
            goto L_0x004b
        L_0x0036:
            r2 = 0
            goto L_0x004b
        L_0x0038:
            int r11 = r7.mVerticalChainStyle
            if (r11 != 0) goto L_0x003e
            r11 = 1
            goto L_0x003f
        L_0x003e:
            r11 = 0
        L_0x003f:
            int r12 = r7.mVerticalChainStyle
            if (r12 != r10) goto L_0x0045
            r12 = 1
            goto L_0x0046
        L_0x0045:
            r12 = 0
        L_0x0046:
            int r7 = r7.mVerticalChainStyle
            if (r7 != r2) goto L_0x0036
            goto L_0x0034
        L_0x004b:
            r14 = r3
            r7 = 0
            r10 = 0
            r13 = 0
            r15 = 0
            r17 = 0
        L_0x0052:
            r9 = 8
            if (r13 != 0) goto L_0x010f
            r18 = r13
            int r13 = r14.getVisibility()
            if (r13 == r9) goto L_0x00a1
            int r10 = r10 + 1
            if (r1 != 0) goto L_0x0069
            int r13 = r14.getWidth()
            float r13 = (float) r13
            float r15 = r15 + r13
            goto L_0x006f
        L_0x0069:
            int r13 = r14.getHeight()
            float r13 = (float) r13
            float r15 = r15 + r13
        L_0x006f:
            if (r14 == r5) goto L_0x007b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r13 = r14.mListAnchors
            r13 = r13[r25]
            int r13 = r13.getMargin()
            float r13 = (float) r13
            float r15 = r15 + r13
        L_0x007b:
            if (r14 == r6) goto L_0x0089
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r13 = r14.mListAnchors
            int r19 = r25 + 1
            r13 = r13[r19]
            int r13 = r13.getMargin()
            float r13 = (float) r13
            float r15 = r15 + r13
        L_0x0089:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r13 = r14.mListAnchors
            r13 = r13[r25]
            int r13 = r13.getMargin()
            float r13 = (float) r13
            float r17 = r17 + r13
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r13 = r14.mListAnchors
            int r19 = r25 + 1
            r13 = r13[r19]
            int r13 = r13.getMargin()
            float r13 = (float) r13
            float r17 = r17 + r13
        L_0x00a1:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r13 = r14.mListAnchors
            r13 = r13[r25]
            int r13 = r14.getVisibility()
            if (r13 == r9) goto L_0x00e0
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r9 = r14.mListDimensionBehaviors
            r9 = r9[r1]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r9 != r13) goto L_0x00e0
            int r7 = r7 + 1
            if (r1 != 0) goto L_0x00c7
            int r9 = r14.mMatchConstraintDefaultWidth
            if (r9 == 0) goto L_0x00bd
            r9 = 0
            return r9
        L_0x00bd:
            r9 = 0
            int r13 = r14.mMatchConstraintMinWidth
            if (r13 != 0) goto L_0x00c6
            int r13 = r14.mMatchConstraintMaxWidth
            if (r13 == 0) goto L_0x00d6
        L_0x00c6:
            return r9
        L_0x00c7:
            r9 = 0
            int r13 = r14.mMatchConstraintDefaultHeight
            if (r13 == 0) goto L_0x00cd
            return r9
        L_0x00cd:
            int r13 = r14.mMatchConstraintMinHeight
            if (r13 != 0) goto L_0x00df
            int r13 = r14.mMatchConstraintMaxHeight
            if (r13 == 0) goto L_0x00d6
            goto L_0x00df
        L_0x00d6:
            float r13 = r14.mDimensionRatio
            r16 = 0
            int r13 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r13 == 0) goto L_0x00e0
            return r9
        L_0x00df:
            return r9
        L_0x00e0:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r14.mListAnchors
            int r13 = r25 + 1
            r9 = r9[r13]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r9.mTarget
            if (r9 == 0) goto L_0x0102
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r9.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r13 = r9.mListAnchors
            r13 = r13[r25]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r13 = r13.mTarget
            if (r13 == 0) goto L_0x0102
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r13 = r9.mListAnchors
            r13 = r13[r25]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r13 = r13.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r13.mOwner
            if (r13 == r14) goto L_0x00ff
            goto L_0x0102
        L_0x00ff:
            r20 = r9
            goto L_0x0104
        L_0x0102:
            r20 = 0
        L_0x0104:
            if (r20 == 0) goto L_0x010c
            r13 = r18
            r14 = r20
            goto L_0x0052
        L_0x010c:
            r13 = 1
            goto L_0x0052
        L_0x010f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r13 = r3.mListAnchors
            r13 = r13[r25]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r13 = r13.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r4.mListAnchors
            int r18 = r25 + 1
            r9 = r9[r18]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r9 = r9.getResolutionNode()
            r21 = r3
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r13.target
            if (r3 == 0) goto L_0x039d
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r9.target
            if (r3 != 0) goto L_0x012d
            goto L_0x039d
        L_0x012d:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r13.target
            int r3 = r3.state
            r0 = 1
            if (r3 != r0) goto L_0x039b
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r9.target
            int r3 = r3.state
            if (r3 == r0) goto L_0x013c
            goto L_0x039b
        L_0x013c:
            if (r7 <= 0) goto L_0x0142
            if (r7 == r10) goto L_0x0142
            r0 = 0
            return r0
        L_0x0142:
            if (r2 != 0) goto L_0x014b
            if (r11 != 0) goto L_0x014b
            if (r12 == 0) goto L_0x0149
            goto L_0x014b
        L_0x0149:
            r0 = 0
            goto L_0x0164
        L_0x014b:
            if (r5 == 0) goto L_0x0157
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r5.mListAnchors
            r0 = r0[r25]
            int r0 = r0.getMargin()
            float r0 = (float) r0
            goto L_0x0158
        L_0x0157:
            r0 = 0
        L_0x0158:
            if (r6 == 0) goto L_0x0164
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r6.mListAnchors
            r3 = r3[r18]
            int r3 = r3.getMargin()
            float r3 = (float) r3
            float r0 = r0 + r3
        L_0x0164:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r13.target
            float r3 = r3.resolvedOffset
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r6 = r9.target
            float r6 = r6.resolvedOffset
            int r9 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x0173
            float r6 = r6 - r3
            float r6 = r6 - r15
            goto L_0x0176
        L_0x0173:
            float r6 = r3 - r6
            float r6 = r6 - r15
        L_0x0176:
            r19 = 1
            if (r7 <= 0) goto L_0x022f
            if (r7 != r10) goto L_0x022f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r14.getParent()
            if (r0 == 0) goto L_0x0190
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r14.getParent()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.mListDimensionBehaviors
            r0 = r0[r1]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r2) goto L_0x0190
            r0 = 0
            return r0
        L_0x0190:
            float r6 = r6 + r15
            float r6 = r6 - r17
            r0 = r21
        L_0x0195:
            if (r0 == 0) goto L_0x022d
            androidx.constraintlayout.solver.Metrics r2 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r2 == 0) goto L_0x01b3
            androidx.constraintlayout.solver.Metrics r2 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r9 = r2.nonresolvedWidgets
            long r9 = r9 - r19
            r2.nonresolvedWidgets = r9
            androidx.constraintlayout.solver.Metrics r2 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r9 = r2.resolvedWidgets
            long r9 = r9 + r19
            r2.resolvedWidgets = r9
            androidx.constraintlayout.solver.Metrics r2 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r9 = r2.chainConnectionResolved
            long r9 = r9 + r19
            r2.chainConnectionResolved = r9
        L_0x01b3:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r2 = r0.mNextChainWidget
            r2 = r2[r1]
            if (r2 != 0) goto L_0x01bf
            if (r0 != r4) goto L_0x01bc
            goto L_0x01bf
        L_0x01bc:
            r9 = r23
            goto L_0x022a
        L_0x01bf:
            float r5 = (float) r7
            float r5 = r6 / r5
            r9 = 0
            int r10 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r10 <= 0) goto L_0x01da
            float[] r5 = r0.mWeight
            r5 = r5[r1]
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x01d3
            r5 = 0
            goto L_0x01da
        L_0x01d3:
            float[] r5 = r0.mWeight
            r5 = r5[r1]
            float r5 = r5 * r6
            float r5 = r5 / r8
        L_0x01da:
            int r9 = r0.getVisibility()
            r10 = 8
            if (r9 != r10) goto L_0x01e3
            r5 = 0
        L_0x01e3:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r0.mListAnchors
            r9 = r9[r25]
            int r9 = r9.getMargin()
            float r9 = (float) r9
            float r3 = r3 + r9
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r0.mListAnchors
            r9 = r9[r25]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r9 = r9.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r10 = r13.resolvedTarget
            r9.resolve(r10, r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r0.mListAnchors
            r9 = r9[r18]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r9 = r9.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r10 = r13.resolvedTarget
            float r3 = r3 + r5
            r9.resolve(r10, r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r0.mListAnchors
            r5 = r5[r25]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r5 = r5.getResolutionNode()
            r9 = r23
            r5.addResolvedValue(r9)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r0.mListAnchors
            r5 = r5[r18]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r5 = r5.getResolutionNode()
            r5.addResolvedValue(r9)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            r0 = r0[r18]
            int r0 = r0.getMargin()
            float r0 = (float) r0
            float r3 = r3 + r0
        L_0x022a:
            r0 = r2
            goto L_0x0195
        L_0x022d:
            r0 = 1
            return r0
        L_0x022f:
            r9 = r23
            r7 = 0
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x0239
            r2 = 1
            r11 = 0
            r12 = 0
        L_0x0239:
            if (r2 == 0) goto L_0x02c2
            float r6 = r6 - r0
            r2 = r21
            float r0 = r2.getBiasPercent(r1)
            float r6 = r6 * r0
            float r3 = r3 + r6
        L_0x0245:
            if (r2 == 0) goto L_0x02bf
            androidx.constraintlayout.solver.Metrics r0 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r0 == 0) goto L_0x0263
            androidx.constraintlayout.solver.Metrics r0 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r5 = r0.nonresolvedWidgets
            long r5 = r5 - r19
            r0.nonresolvedWidgets = r5
            androidx.constraintlayout.solver.Metrics r0 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r5 = r0.resolvedWidgets
            long r5 = r5 + r19
            r0.resolvedWidgets = r5
            androidx.constraintlayout.solver.Metrics r0 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r5 = r0.chainConnectionResolved
            long r5 = r5 + r19
            r0.chainConnectionResolved = r5
        L_0x0263:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r2.mNextChainWidget
            r0 = r0[r1]
            if (r0 != 0) goto L_0x026b
            if (r2 != r4) goto L_0x02bd
        L_0x026b:
            if (r1 != 0) goto L_0x0273
            int r5 = r2.getWidth()
            float r5 = (float) r5
            goto L_0x0278
        L_0x0273:
            int r5 = r2.getHeight()
            float r5 = (float) r5
        L_0x0278:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r2.mListAnchors
            r6 = r6[r25]
            int r6 = r6.getMargin()
            float r6 = (float) r6
            float r3 = r3 + r6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r2.mListAnchors
            r6 = r6[r25]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r7 = r13.resolvedTarget
            r6.resolve(r7, r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r2.mListAnchors
            r6 = r6[r18]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r7 = r13.resolvedTarget
            float r3 = r3 + r5
            r6.resolve(r7, r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r2.mListAnchors
            r5 = r5[r25]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r5 = r5.getResolutionNode()
            r5.addResolvedValue(r9)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r2.mListAnchors
            r5 = r5[r18]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r5 = r5.getResolutionNode()
            r5.addResolvedValue(r9)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r2.mListAnchors
            r2 = r2[r18]
            int r2 = r2.getMargin()
            float r2 = (float) r2
            float r3 = r3 + r2
        L_0x02bd:
            r2 = r0
            goto L_0x0245
        L_0x02bf:
            r0 = 1
            goto L_0x039a
        L_0x02c2:
            r2 = r21
            if (r11 != 0) goto L_0x02c8
            if (r12 == 0) goto L_0x02bf
        L_0x02c8:
            if (r11 == 0) goto L_0x02cc
            float r6 = r6 - r0
            goto L_0x02cf
        L_0x02cc:
            if (r12 == 0) goto L_0x02cf
            float r6 = r6 - r0
        L_0x02cf:
            int r0 = r10 + 1
            float r0 = (float) r0
            float r0 = r6 / r0
            if (r12 == 0) goto L_0x02e3
            r7 = 1
            if (r10 <= r7) goto L_0x02df
            int r0 = r10 + -1
            float r0 = (float) r0
            float r0 = r6 / r0
            goto L_0x02e3
        L_0x02df:
            r0 = 1073741824(0x40000000, float:2.0)
            float r0 = r6 / r0
        L_0x02e3:
            int r6 = r2.getVisibility()
            r7 = 8
            if (r6 == r7) goto L_0x02ee
            float r6 = r3 + r0
            goto L_0x02ef
        L_0x02ee:
            r6 = r3
        L_0x02ef:
            if (r12 == 0) goto L_0x02fe
            r7 = 1
            if (r10 <= r7) goto L_0x02fe
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r5.mListAnchors
            r6 = r6[r25]
            int r6 = r6.getMargin()
            float r6 = (float) r6
            float r6 = r6 + r3
        L_0x02fe:
            if (r11 == 0) goto L_0x030c
            if (r5 == 0) goto L_0x030c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r5.mListAnchors
            r3 = r3[r25]
            int r3 = r3.getMargin()
            float r3 = (float) r3
            float r6 = r6 + r3
        L_0x030c:
            if (r2 == 0) goto L_0x02bf
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r3 == 0) goto L_0x032a
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r7 = r3.nonresolvedWidgets
            long r7 = r7 - r19
            r3.nonresolvedWidgets = r7
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r7 = r3.resolvedWidgets
            long r7 = r7 + r19
            r3.resolvedWidgets = r7
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            long r7 = r3.chainConnectionResolved
            long r7 = r7 + r19
            r3.chainConnectionResolved = r7
        L_0x032a:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r3 = r2.mNextChainWidget
            r3 = r3[r1]
            if (r3 != 0) goto L_0x0336
            if (r2 != r4) goto L_0x0333
            goto L_0x0336
        L_0x0333:
            r7 = 8
            goto L_0x0397
        L_0x0336:
            if (r1 != 0) goto L_0x033e
            int r7 = r2.getWidth()
            float r7 = (float) r7
            goto L_0x0343
        L_0x033e:
            int r7 = r2.getHeight()
            float r7 = (float) r7
        L_0x0343:
            if (r2 == r5) goto L_0x034f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r25]
            int r8 = r8.getMargin()
            float r8 = (float) r8
            float r6 = r6 + r8
        L_0x034f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r25]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r10 = r13.resolvedTarget
            r8.resolve(r10, r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r18]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r10 = r13.resolvedTarget
            float r11 = r6 + r7
            r8.resolve(r10, r11)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r25]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            r8.addResolvedValue(r9)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r18]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            r8.addResolvedValue(r9)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r2.mListAnchors
            r2 = r2[r18]
            int r2 = r2.getMargin()
            float r2 = (float) r2
            float r7 = r7 + r2
            float r6 = r6 + r7
            if (r3 == 0) goto L_0x0333
            int r2 = r3.getVisibility()
            r7 = 8
            if (r2 == r7) goto L_0x0397
            float r6 = r6 + r0
        L_0x0397:
            r2 = r3
            goto L_0x030c
        L_0x039a:
            return r0
        L_0x039b:
            r0 = 0
            return r0
        L_0x039d:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Optimizer.applyChainOptimized(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):boolean");
    }

    static void setOptimizedWidget(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        constraintWidget.mListAnchors[i3].getResolutionNode().resolvedTarget = constraintWidget.getParent().mLeft.getResolutionNode();
        constraintWidget.mListAnchors[i3].getResolutionNode().resolvedOffset = (float) i2;
        constraintWidget.mListAnchors[i3].getResolutionNode().state = 1;
        constraintWidget.mListAnchors[i4].getResolutionNode().resolvedTarget = constraintWidget.mListAnchors[i3].getResolutionNode();
        constraintWidget.mListAnchors[i4].getResolutionNode().resolvedOffset = (float) constraintWidget.getLength(i);
        constraintWidget.mListAnchors[i4].getResolutionNode().state = 1;
    }
}
