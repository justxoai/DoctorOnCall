package vn.edu.usth.doconcall.Schedule;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class Fragment_schedule_changing extends FragmentStateAdapter {
    public Fragment_schedule_changing(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Monthly_Fragment();
            case 1:
                return new Weekly_Fragment();
            case 2:
                return new Daily_Fragment();
            default:
                return new Monthly_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
