package com.trainstation.frettirtest2;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.trainstation.frettirtest2.responses.NewsResponse;
import com.trainstation.frettirtest2.responses.NewsResultObject;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;

/**
 * Created by Helgi on 17/01/16.
 */
public class MyViewPagerFragment2 extends Fragment {


    ListView list;


    public MyViewPagerFragment2(){

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View rootView = inflater.inflate(R.layout.fragment_view_pager, container, false);

        ((MainActivity) getActivity()).getNewsResponse().subscribe(new Observer<NewsResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                // TODO: show toast
                Log.e("MyViewPagerFragment", "Couldn't get response", e);
            }

            @Override
            public void onNext(final NewsResponse newsResponse) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list = (ListView) rootView.findViewById(R.id.list);

                        ListCellAdapter listCellAdapter = new ListCellAdapter(getActivity(), createCellData(newsResponse), getContext());
                        list.setAdapter(listCellAdapter);
                    }
                });

            }
        });
        return rootView;

    }


    private List<CellData> createCellData(NewsResponse newsResponse){

        List<CellData> cellDataList = new ArrayList<CellData>();

        for (NewsResultObject resultObject : newsResponse.results)
        {
            CellData cellData = new CellData();
            cellData.text = resultObject.trackName;
            cellData.imageUrl = resultObject.artworkUrl100;
            cellData.title = resultObject.artistName;
            cellData.url = resultObject.trackViewUrl;

            cellDataList.add(cellData);
        }

        return cellDataList;
    }



/*

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_view_pager, container, false);

        return rootView;

    }*/

}
