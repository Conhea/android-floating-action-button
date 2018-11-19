package com.github.conhea.floatingactionbutton;

import android.content.Context;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;


/**
 * Layout behavior that can be applied to either {@link FloatingActionButton} or {@link FloatingActionsMenu}
 * to make components automatically animate to stay above {@code Snackbar} instances within the
 * same parent {@code CoordinatorLayout}.
 * <p>
 * Usage:
 * <pre>
 * &lt;android.support.design.widget.CoordinatorLayout ...&gt;
 *   ...
 *   &lt;com.getbase.floatingactionbutton.FloatingActionsMenu
 *     ...
 *     app:layout_behavior="com.getbase.floatingactionbutton.FloatingActionButtonSnackbarBehavior" /&gt;
 * &lt;/android.support.design.widget.CoordinatorLayout&gt;
 * </pre>
 */
public class FloatingActionButtonSnackbarBehavior extends androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior<View> {

    private float mTranslationY;

    @SuppressWarnings("unused")
    public FloatingActionButtonSnackbarBehavior() {
        super();
    }

    @SuppressWarnings("unused")
    public FloatingActionButtonSnackbarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Find the {@code translation Y} value for any child Snackbar components.
     *
     * @return 0.0F if there are no Snackbar components found, otherwise returns the min offset
     * that the FAB component should be animated.
     */
    private float getFabTranslationYForSnackbar(androidx.coordinatorlayout.widget.CoordinatorLayout parent, View fab) {
        float minOffset = 0.0F;
        final List<View> dependencies = parent.getDependencies(fab);

        for (View view : dependencies) {
            if (view instanceof com.google.android.material.snackbar.Snackbar.SnackbarLayout && parent.doViewsOverlap(fab, view)) {
                minOffset = Math.min(minOffset, view.getTranslationY() - (float) view.getHeight());
            }
        }

        return minOffset;
    }

    @Override
    public boolean layoutDependsOn(androidx.coordinatorlayout.widget.CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof com.google.android.material.snackbar.Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(androidx.coordinatorlayout.widget.CoordinatorLayout parent, View child, View dependency) {
        if (dependency instanceof com.google.android.material.snackbar.Snackbar.SnackbarLayout) {
            this.updateFabTranslationForSnackbar(parent, child, dependency);
        }
        return false;
    }

    /**
     * Animate FAB on snackbar change.
     */
    private void updateFabTranslationForSnackbar(androidx.coordinatorlayout.widget.CoordinatorLayout parent, View fab, View snackbar) {
        final float translationY = getFabTranslationYForSnackbar(parent, fab);
        if (translationY != this.mTranslationY) {
            fab.animate().cancel();
            if (Math.abs(translationY - this.mTranslationY) == (float) snackbar.getHeight()) {
                fab.animate().translationY(translationY).setInterpolator(new FastOutSlowInInterpolator());
            } else {
                fab.setTranslationY(translationY);
            }

            this.mTranslationY = translationY;
        }
    }
}
