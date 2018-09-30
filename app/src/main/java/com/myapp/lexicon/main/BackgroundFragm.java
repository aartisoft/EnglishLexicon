package com.myapp.lexicon.main;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;

import com.myapp.lexicon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BackgroundFragm extends Fragment
{
    View fragmentView = null;

    // картинки для фона
    public static int[] imagesId = new int[]
            {
                    R.drawable.img_uk,
                    R.drawable.img_uk1,
                    R.drawable.img_uk2,
                    R.drawable.img_uk3,
                    R.drawable.img_uk4,
                    R.drawable.img_uk5,
                    R.drawable.img_uk6,
                    R.drawable.img_uk7,
                    R.drawable.img_uk8,
                    R.drawable.img_uk9,
                    R.drawable.img_uk10,
                    R.drawable.img_uk11,
                    R.drawable.img_uk12,
                    R.drawable.img_uk13,
                    R.drawable.img_uk14,
                    R.drawable.img_uk15,
                    R.drawable.img_uk16,
                    R.drawable.img_uk17,
                    R.drawable.img_uk18,
                    R.drawable.img_uk19,
                    R.drawable.img_uk20,
                    R.drawable.img_uk21,
                    R.drawable.img_uk22,
                    R.drawable.img_uk23,
                    R.drawable.img_uk24,
                    R.drawable.img_uk25,
                    R.drawable.img_uk26,
                    R.drawable.img_uk27,
                    R.drawable.img_uk28,
                    R.drawable.img_usa3,
                    R.drawable.img_usa4
            };
    AdapterViewFlipper adapterViewFlipper; // TODO: AdapterViewFlipper: 1. Этот компонент будет использоваться для анимированного изменения фонового изображения

    public BackgroundFragm()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRetainInstance(true); // TODO: Fragment 3. true - что бы фрагмент не пересоздавался при изменении конфигурации
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if (fragmentView == null)   // TODO: Fragment 4. Обязательная проверка, что бы не раздувать новый макет при повороте экрана
        {
            fragmentView = inflater.inflate(R.layout.a_fragment_background, container, false);
        }

        if (savedInstanceState == null) // проверка, что бы не перезапускался AdapterViewFlipper каждый раз при повороте экрана
        {
            adapterViewFlipper = fragmentView.findViewById(R.id.adapter_view_flipper);

            // TODO: AdapterViewFlipper: 7. создание адаптера и запуск анимации
            FragmentActivity activity = getActivity();
            if (activity != null)
            {
                FlipperAdapter flipperAdapter = new FlipperAdapter(activity, imagesId);
                adapterViewFlipper.setAdapter(flipperAdapter);
                adapterViewFlipper.setFlipInterval(20000);

                // предварительно создать в директории res новую директорию animator и добавить в нее ресурсы анимации (см. директорию res/animator)
                adapterViewFlipper.setInAnimation(getActivity(), R.animator.in_animator);
                adapterViewFlipper.setOutAnimation(getActivity(), R.animator.out_animator);
                adapterViewFlipper.setAutoStart(true);
            }
        }

        return fragmentView;
    }

}
