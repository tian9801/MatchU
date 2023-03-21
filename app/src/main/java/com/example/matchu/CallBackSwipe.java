package com.example.matchu;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class CallBackSwipe extends DiffUtil.Callback {

        private List<College> hi, by;

        public CallBackSwipe(List<College> hi, List<College> by) {
                 this.hi = hi;
                this.by = by;
        }

@Override
public int getOldListSize() {
        return hi.size();
        }

@Override
public int getNewListSize() {
        return by.size();
        }

@Override
public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return hi.get(oldItemPosition).getImage() == by.get(newItemPosition).getImage();
        }

@Override
public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return hi.get(oldItemPosition) == by.get(newItemPosition);
        }
        }

