package vn.edu.usth.intern.project.Home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Fragment_home_changing  extends FragmentStateAdapter {
    public Fragment_home_changing(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Dashboard_Fragment();
            case 1:
                return new Notification_Fragment();
            default:
                return new Dashboard_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}