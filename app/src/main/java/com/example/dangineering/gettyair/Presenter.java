package com.example.dangineering.gettyair;

import com.example.dangineering.gettyair.network.GettyRepository;
import com.example.dangineering.gettyair.network.respmodel.Resp;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter {
    CustomView view;
    GettyRepository.ApiService apiService;

    public Presenter(CustomView customView) {

        this.view = customView;
        apiService = GettyRepository.retrofit.create(GettyRepository.ApiService.class);
    }

    public void onSearch(String query, int startYear, int startMo, int startDay,
                  int endYear, int endMo, int endDay) {

        String errormsg= "";

        if (query.isEmpty()) {
            errormsg += "Query cannot be empty";
        }

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        if (startYear < year || startMo < month || startDay < day) {
            errormsg += " start cannot be before today";
        }

        if (endYear < year || endMo < startMo || endDay < startDay) {
            errormsg += "end date has to be after start";
        }

        if (!errormsg.isEmpty()) {
            view.showError(errormsg);
            return;
        }


        apiService.search(query).enqueue(new Callback<Resp>() {
            @Override
            public void onResponse(Call<Resp> call, Response<Resp> response) {
                view.add(response.body().getImages());
            }

            @Override
            public void onFailure(Call<Resp> call, Throwable t) {
                view.showError("Network error");
            }
        });



    }
}
