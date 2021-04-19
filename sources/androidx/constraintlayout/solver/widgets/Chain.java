package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            int i4 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = i4;
            i3 = 0;
        } else {
            i3 = 2;
            int i5 = constraintWidgetContainer.mVerticalChainsSize;
            i2 = i5;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            ChainHead chainHead = chainHeadArr[i6];
            chainHead.define();
            if (!constraintWidgetContainer.optimizeFor(4)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            } else if (!Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i3, chainHead)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r2.mVerticalChainStyle == 2) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x03b4  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x03b7  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x03d3  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x03d6  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x04f2  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x051c  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0521  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x0527  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x052c  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0530  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0542  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x019e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r48, androidx.constraintlayout.solver.LinearSystem r49, int r50, int r51, androidx.constraintlayout.solver.widgets.ChainHead r52) {
        /*
            r0 = r48
            r9 = r49
            r1 = r52
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r1.mFirst
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r1.mLast
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r1.mFirstVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r1.mLastVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r1.mHead
            float r3 = r1.mTotalWeight
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r1.mFirstMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r1.mLastMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r50]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7 = 1
            if (r4 != r5) goto L_0x0021
            r4 = 1
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            r5 = 2
            if (r50 != 0) goto L_0x0042
            int r8 = r2.mHorizontalChainStyle
            if (r8 != 0) goto L_0x002b
            r8 = 1
            goto L_0x002c
        L_0x002b:
            r8 = 0
        L_0x002c:
            int r6 = r2.mHorizontalChainStyle
            if (r6 != r7) goto L_0x0032
            r6 = 1
            goto L_0x0033
        L_0x0032:
            r6 = 0
        L_0x0033:
            int r7 = r2.mHorizontalChainStyle
            if (r7 != r5) goto L_0x0039
        L_0x0037:
            r5 = 1
            goto L_0x003a
        L_0x0039:
            r5 = 0
        L_0x003a:
            r7 = r5
            r18 = r6
            r17 = r8
            r6 = r11
            r5 = 0
            goto L_0x0056
        L_0x0042:
            int r6 = r2.mVerticalChainStyle
            if (r6 != 0) goto L_0x0048
            r8 = 1
            goto L_0x0049
        L_0x0048:
            r8 = 0
        L_0x0049:
            int r6 = r2.mVerticalChainStyle
            r7 = 1
            if (r6 != r7) goto L_0x0050
            r6 = 1
            goto L_0x0051
        L_0x0050:
            r6 = 0
        L_0x0051:
            int r7 = r2.mVerticalChainStyle
            if (r7 != r5) goto L_0x0039
            goto L_0x0037
        L_0x0056:
            r22 = 0
            if (r5 != 0) goto L_0x0135
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r6.mListAnchors
            r8 = r8[r51]
            if (r4 != 0) goto L_0x0066
            if (r7 == 0) goto L_0x0063
            goto L_0x0066
        L_0x0063:
            r24 = 4
            goto L_0x0068
        L_0x0066:
            r24 = 1
        L_0x0068:
            int r25 = r8.getMargin()
            r26 = r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mTarget
            if (r3 == 0) goto L_0x007c
            if (r6 == r11) goto L_0x007c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mTarget
            int r3 = r3.getMargin()
            int r25 = r25 + r3
        L_0x007c:
            r3 = r25
            if (r7 == 0) goto L_0x008a
            if (r6 == r11) goto L_0x008a
            if (r6 == r13) goto L_0x008a
            r28 = r2
            r27 = r5
            r5 = 6
            goto L_0x009a
        L_0x008a:
            if (r17 == 0) goto L_0x0094
            if (r4 == 0) goto L_0x0094
            r28 = r2
            r27 = r5
            r5 = 4
            goto L_0x009a
        L_0x0094:
            r28 = r2
            r27 = r5
            r5 = r24
        L_0x009a:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r8.mTarget
            if (r2 == 0) goto L_0x00c7
            if (r6 != r13) goto L_0x00af
            androidx.constraintlayout.solver.SolverVariable r2 = r8.mSolverVariable
            r29 = r11
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r8.mTarget
            androidx.constraintlayout.solver.SolverVariable r11 = r11.mSolverVariable
            r30 = r7
            r7 = 5
            r9.addGreaterThan(r2, r11, r3, r7)
            goto L_0x00bd
        L_0x00af:
            r30 = r7
            r29 = r11
            androidx.constraintlayout.solver.SolverVariable r2 = r8.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r8.mTarget
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            r11 = 6
            r9.addGreaterThan(r2, r7, r3, r11)
        L_0x00bd:
            androidx.constraintlayout.solver.SolverVariable r2 = r8.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r8.mTarget
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            r9.addEquality(r2, r7, r3, r5)
            goto L_0x00cb
        L_0x00c7:
            r30 = r7
            r29 = r11
        L_0x00cb:
            if (r4 == 0) goto L_0x0102
            int r2 = r6.getVisibility()
            r3 = 8
            if (r2 == r3) goto L_0x00f1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r6.mListDimensionBehaviors
            r2 = r2[r50]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x00f1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r6.mListAnchors
            int r3 = r51 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r6.mListAnchors
            r3 = r3[r51]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r5 = 0
            r7 = 5
            r9.addGreaterThan(r2, r3, r5, r7)
            goto L_0x00f2
        L_0x00f1:
            r5 = 0
        L_0x00f2:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r6.mListAnchors
            r2 = r2[r51]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r0.mListAnchors
            r3 = r3[r51]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r7 = 6
            r9.addGreaterThan(r2, r3, r5, r7)
        L_0x0102:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r6.mListAnchors
            int r3 = r51 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0123
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r51]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0123
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r51]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            if (r3 == r6) goto L_0x0121
            goto L_0x0123
        L_0x0121:
            r22 = r2
        L_0x0123:
            if (r22 == 0) goto L_0x012a
            r6 = r22
            r5 = r27
            goto L_0x012b
        L_0x012a:
            r5 = 1
        L_0x012b:
            r3 = r26
            r2 = r28
            r11 = r29
            r7 = r30
            goto L_0x0056
        L_0x0135:
            r28 = r2
            r26 = r3
            r30 = r7
            r29 = r11
            if (r14 == 0) goto L_0x0161
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r12.mListAnchors
            int r3 = r51 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0161
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r5 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r12.mListAnchors
            r3 = r6[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            int r2 = r2.getMargin()
            int r2 = -r2
            r8 = 5
            r9.addLowerThan(r5, r3, r2, r8)
            goto L_0x0162
        L_0x0161:
            r8 = 5
        L_0x0162:
            if (r4 == 0) goto L_0x017e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            int r2 = r51 + 1
            r0 = r0[r2]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r12.mListAnchors
            r3 = r3[r2]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r12.mListAnchors
            r2 = r4[r2]
            int r2 = r2.getMargin()
            r4 = 6
            r9.addGreaterThan(r0, r3, r2, r4)
        L_0x017e:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r0 = r1.mWeightedMatchConstraintsWidgets
            if (r0 == 0) goto L_0x022e
            int r2 = r0.size()
            r7 = 1
            if (r2 <= r7) goto L_0x022e
            boolean r3 = r1.mHasUndefinedWeights
            if (r3 == 0) goto L_0x0196
            boolean r3 = r1.mHasComplexMatchWeights
            if (r3 != 0) goto L_0x0196
            int r3 = r1.mWidgetsMatchCount
            float r3 = (float) r3
            r26 = r3
        L_0x0196:
            r3 = 0
            r5 = r22
            r4 = 0
            r32 = 0
        L_0x019c:
            if (r4 >= r2) goto L_0x022e
            java.lang.Object r6 = r0.get(r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r6
            float[] r11 = r6.mWeight
            r11 = r11[r50]
            int r16 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r16 >= 0) goto L_0x01cc
            boolean r11 = r1.mHasComplexMatchWeights
            if (r11 == 0) goto L_0x01c6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r11 = r6.mListAnchors
            int r16 = r51 + 1
            r11 = r11[r16]
            androidx.constraintlayout.solver.SolverVariable r11 = r11.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r6.mListAnchors
            r6 = r6[r51]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r7 = 0
            r8 = 4
            r9.addEquality(r11, r6, r7, r8)
            r8 = 6
            r11 = 0
            goto L_0x01e4
        L_0x01c6:
            r8 = 4
            r7 = 1065353216(0x3f800000, float:1.0)
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01cd
        L_0x01cc:
            r8 = 4
        L_0x01cd:
            int r7 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x01e7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r6.mListAnchors
            int r11 = r51 + 1
            r7 = r7[r11]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r6.mListAnchors
            r6 = r6[r51]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r8 = 6
            r11 = 0
            r9.addEquality(r7, r6, r11, r8)
        L_0x01e4:
            r40 = r0
            goto L_0x0225
        L_0x01e7:
            r7 = 0
            r8 = 6
            if (r5 == 0) goto L_0x0220
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r5.mListAnchors
            r3 = r3[r51]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r5.mListAnchors
            int r15 = r51 + 1
            r5 = r5[r15]
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r6.mListAnchors
            r7 = r7[r51]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r6.mListAnchors
            r8 = r8[r15]
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
            r40 = r0
            androidx.constraintlayout.solver.ArrayRow r0 = r49.createRow()
            r31 = r0
            r33 = r26
            r34 = r11
            r35 = r3
            r36 = r5
            r37 = r7
            r38 = r8
            r31.createRowEqualMatchDimensions(r32, r33, r34, r35, r36, r37, r38)
            r9.addConstraint(r0)
            goto L_0x0222
        L_0x0220:
            r40 = r0
        L_0x0222:
            r5 = r6
            r32 = r11
        L_0x0225:
            int r4 = r4 + 1
            r0 = r40
            r3 = 0
            r7 = 1
            r8 = 5
            goto L_0x019c
        L_0x022e:
            if (r13 == 0) goto L_0x029b
            if (r13 == r14) goto L_0x0234
            if (r30 == 0) goto L_0x029b
        L_0x0234:
            r11 = r29
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r11.mListAnchors
            r0 = r0[r51]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            int r2 = r51 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r51]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0251
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r51]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0253
        L_0x0251:
            r3 = r22
        L_0x0253:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r12.mListAnchors
            r4 = r4[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x0265
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r12.mListAnchors
            r4 = r4[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            r5 = r4
            goto L_0x0267
        L_0x0265:
            r5 = r22
        L_0x0267:
            if (r13 != r14) goto L_0x0271
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r51]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            r1 = r1[r2]
        L_0x0271:
            if (r3 == 0) goto L_0x0508
            if (r5 == 0) goto L_0x0508
            if (r50 != 0) goto L_0x027d
            r2 = r28
            float r2 = r2.mHorizontalBiasPercent
        L_0x027b:
            r4 = r2
            goto L_0x0282
        L_0x027d:
            r2 = r28
            float r2 = r2.mVerticalBiasPercent
            goto L_0x027b
        L_0x0282:
            int r6 = r0.getMargin()
            int r7 = r1.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r8 = r1.mSolverVariable
            r10 = 5
            r0 = r49
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0508
        L_0x029b:
            r11 = r29
            if (r17 == 0) goto L_0x03bf
            if (r13 == 0) goto L_0x03bf
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x02ae
            int r0 = r1.mWidgetsCount
            int r1 = r1.mWidgetsMatchCount
            if (r0 != r1) goto L_0x02ae
            r39 = 1
            goto L_0x02b0
        L_0x02ae:
            r39 = 0
        L_0x02b0:
            r7 = r13
            r8 = r7
        L_0x02b2:
            if (r8 == 0) goto L_0x0506
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r8.mNextChainWidget
            r0 = r0[r50]
            r6 = r0
        L_0x02b9:
            if (r6 == 0) goto L_0x02c8
            int r0 = r6.getVisibility()
            r5 = 8
            if (r0 != r5) goto L_0x02ca
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r6.mNextChainWidget
            r6 = r0[r50]
            goto L_0x02b9
        L_0x02c8:
            r5 = 8
        L_0x02ca:
            if (r6 != 0) goto L_0x02dd
            if (r8 != r14) goto L_0x02cf
            goto L_0x02dd
        L_0x02cf:
            r19 = r6
            r20 = r7
            r16 = r8
        L_0x02d5:
            r9 = 8
            r21 = 6
            r23 = 4
            goto L_0x03ae
        L_0x02dd:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r8.mListAnchors
            r0 = r0[r51]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x02ec
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x02ee
        L_0x02ec:
            r2 = r22
        L_0x02ee:
            if (r7 == r8) goto L_0x02f9
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            int r3 = r51 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0310
        L_0x02f9:
            if (r8 != r13) goto L_0x0310
            if (r7 != r8) goto L_0x0310
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r51]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x030e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r51]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0310
        L_0x030e:
            r2 = r22
        L_0x0310:
            int r0 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r8.mListAnchors
            int r4 = r51 + 1
            r3 = r3[r4]
            int r3 = r3.getMargin()
            if (r6 == 0) goto L_0x0336
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r6.mListAnchors
            r5 = r5[r51]
            r41 = r6
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            r42 = r5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            r5 = r5[r4]
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
        L_0x0330:
            r47 = r6
            r6 = r5
            r5 = r47
            goto L_0x0352
        L_0x0336:
            r41 = r6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r12.mListAnchors
            r5 = r5[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x0345
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            r43 = r5
            goto L_0x0349
        L_0x0345:
            r43 = r5
            r6 = r22
        L_0x0349:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            r5 = r5[r4]
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            r42 = r43
            goto L_0x0330
        L_0x0352:
            if (r42 == 0) goto L_0x0359
            int r15 = r42.getMargin()
            int r3 = r3 + r15
        L_0x0359:
            if (r7 == 0) goto L_0x0367
            r44 = r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r7.mListAnchors
            r3 = r3[r4]
            int r3 = r3.getMargin()
            int r0 = r0 + r3
            goto L_0x0369
        L_0x0367:
            r44 = r3
        L_0x0369:
            if (r1 == 0) goto L_0x03a6
            if (r2 == 0) goto L_0x03a6
            if (r5 == 0) goto L_0x03a6
            if (r6 == 0) goto L_0x03a6
            if (r8 != r13) goto L_0x037b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r51]
            int r0 = r0.getMargin()
        L_0x037b:
            r3 = r0
            if (r8 != r14) goto L_0x0388
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r4]
            int r0 = r0.getMargin()
            r44 = r0
        L_0x0388:
            if (r39 == 0) goto L_0x038c
            r15 = 6
            goto L_0x038d
        L_0x038c:
            r15 = 4
        L_0x038d:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r49
            r16 = 8
            r19 = r41
            r20 = r7
            r7 = r44
            r16 = r8
            r9 = 8
            r21 = 6
            r23 = 4
            r8 = r15
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x03ae
        L_0x03a6:
            r20 = r7
            r16 = r8
            r19 = r41
            goto L_0x02d5
        L_0x03ae:
            int r0 = r16.getVisibility()
            if (r0 == r9) goto L_0x03b7
            r7 = r16
            goto L_0x03b9
        L_0x03b7:
            r7 = r20
        L_0x03b9:
            r8 = r19
            r9 = r49
            goto L_0x02b2
        L_0x03bf:
            r9 = 8
            r21 = 6
            r23 = 4
            if (r18 == 0) goto L_0x0506
            if (r13 == 0) goto L_0x0506
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x03d6
            int r0 = r1.mWidgetsCount
            int r1 = r1.mWidgetsMatchCount
            if (r0 != r1) goto L_0x03d6
            r39 = 1
            goto L_0x03d8
        L_0x03d6:
            r39 = 0
        L_0x03d8:
            r7 = r13
            r8 = r7
        L_0x03da:
            if (r8 == 0) goto L_0x04a0
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r8.mNextChainWidget
            r0 = r0[r50]
        L_0x03e0:
            if (r0 == 0) goto L_0x03ed
            int r1 = r0.getVisibility()
            if (r1 != r9) goto L_0x03ed
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r0.mNextChainWidget
            r0 = r0[r50]
            goto L_0x03e0
        L_0x03ed:
            if (r8 == r13) goto L_0x048b
            if (r8 == r14) goto L_0x048b
            if (r0 == 0) goto L_0x048b
            if (r0 != r14) goto L_0x03f8
            r6 = r22
            goto L_0x03f9
        L_0x03f8:
            r6 = r0
        L_0x03f9:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r8.mListAnchors
            r0 = r0[r51]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x0407
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
        L_0x0407:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            int r3 = r51 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            int r0 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r8.mListAnchors
            r4 = r4[r3]
            int r4 = r4.getMargin()
            if (r6 == 0) goto L_0x0436
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r6.mListAnchors
            r5 = r5[r51]
            androidx.constraintlayout.solver.SolverVariable r9 = r5.mSolverVariable
            r45 = r6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r5.mTarget
            if (r6 == 0) goto L_0x042e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r5.mTarget
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            goto L_0x0430
        L_0x042e:
            r6 = r22
        L_0x0430:
            r47 = r9
            r9 = r6
            r6 = r47
            goto L_0x044b
        L_0x0436:
            r45 = r6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            r5 = r5[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x0443
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            goto L_0x0445
        L_0x0443:
            r6 = r22
        L_0x0445:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r8.mListAnchors
            r9 = r9[r3]
            androidx.constraintlayout.solver.SolverVariable r9 = r9.mSolverVariable
        L_0x044b:
            if (r5 == 0) goto L_0x0452
            int r5 = r5.getMargin()
            int r4 = r4 + r5
        L_0x0452:
            r15 = r4
            if (r7 == 0) goto L_0x045e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r7.mListAnchors
            r3 = r4[r3]
            int r3 = r3.getMargin()
            int r0 = r0 + r3
        L_0x045e:
            r3 = r0
            if (r39 == 0) goto L_0x0464
            r16 = 6
            goto L_0x0466
        L_0x0464:
            r16 = 4
        L_0x0466:
            if (r1 == 0) goto L_0x0482
            if (r2 == 0) goto L_0x0482
            if (r6 == 0) goto L_0x0482
            if (r9 == 0) goto L_0x0482
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r49
            r5 = r6
            r19 = r45
            r6 = r9
            r9 = r7
            r7 = r15
            r15 = r8
            r46 = r9
            r9 = 5
            r8 = r16
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0488
        L_0x0482:
            r46 = r7
            r15 = r8
            r19 = r45
            r9 = 5
        L_0x0488:
            r8 = r19
            goto L_0x0490
        L_0x048b:
            r46 = r7
            r15 = r8
            r9 = 5
            r8 = r0
        L_0x0490:
            int r0 = r15.getVisibility()
            r1 = 8
            if (r0 == r1) goto L_0x049a
            r7 = r15
            goto L_0x049c
        L_0x049a:
            r7 = r46
        L_0x049c:
            r9 = 8
            goto L_0x03da
        L_0x04a0:
            r9 = 5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r51]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r11.mListAnchors
            r1 = r1[r51]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            int r3 = r51 + 1
            r10 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r12.mListAnchors
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r2.mTarget
            if (r1 == 0) goto L_0x04f2
            if (r13 == r14) goto L_0x04ca
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            int r0 = r0.getMargin()
            r8 = r49
            r8.addEquality(r2, r1, r0, r9)
        L_0x04c8:
            r9 = r8
            goto L_0x04f4
        L_0x04ca:
            r8 = r49
            if (r11 == 0) goto L_0x04c8
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r3 = r1.mSolverVariable
            int r4 = r0.getMargin()
            r5 = 1056964608(0x3f000000, float:0.5)
            androidx.constraintlayout.solver.SolverVariable r6 = r10.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r7 = r11.mSolverVariable
            int r15 = r10.getMargin()
            r16 = 5
            r0 = r49
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r15
            r9 = r8
            r8 = r16
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04f4
        L_0x04f2:
            r9 = r49
        L_0x04f4:
            if (r11 == 0) goto L_0x0508
            if (r13 == r14) goto L_0x0508
            androidx.constraintlayout.solver.SolverVariable r0 = r10.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r1 = r11.mSolverVariable
            int r2 = r10.getMargin()
            int r2 = -r2
            r3 = 5
            r9.addEquality(r0, r1, r2, r3)
            goto L_0x0508
        L_0x0506:
            r9 = r49
        L_0x0508:
            if (r17 != 0) goto L_0x050c
            if (r18 == 0) goto L_0x056f
        L_0x050c:
            if (r13 == 0) goto L_0x056f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r51]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r14.mListAnchors
            int r2 = r51 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            if (r3 == 0) goto L_0x0521
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0523
        L_0x0521:
            r3 = r22
        L_0x0523:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x052c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            goto L_0x052e
        L_0x052c:
            r4 = r22
        L_0x052e:
            if (r12 == r14) goto L_0x053f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r12.mListAnchors
            r4 = r4[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r4.mTarget
            if (r5 == 0) goto L_0x053d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            goto L_0x053f
        L_0x053d:
            r4 = r22
        L_0x053f:
            r5 = r4
            if (r13 != r14) goto L_0x054a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r51]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            r1 = r1[r2]
        L_0x054a:
            if (r3 == 0) goto L_0x056f
            if (r5 == 0) goto L_0x056f
            r4 = 1056964608(0x3f000000, float:0.5)
            int r6 = r0.getMargin()
            if (r14 != 0) goto L_0x0557
            goto L_0x0558
        L_0x0557:
            r12 = r14
        L_0x0558:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r12.mListAnchors
            r2 = r7[r2]
            int r7 = r2.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r8 = r1.mSolverVariable
            r10 = 5
            r0 = r49
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x056f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
