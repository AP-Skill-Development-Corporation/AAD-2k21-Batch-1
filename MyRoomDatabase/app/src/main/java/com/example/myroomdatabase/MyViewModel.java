package com.example.myroomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    StudentRepo studentRepo;
    LiveData<List<StudentEntity>> listLiveData_model;
    public MyViewModel(@NonNull Application application) {
        super(application);
        studentRepo=new StudentRepo(application);
        listLiveData_model=studentRepo.listLiveData;
    }
    public void insert(StudentEntity entity){
        studentRepo.insert(entity);
    }
    public void update(StudentEntity entity){
        studentRepo.update(entity);
    } public void delete(StudentEntity entity){
        studentRepo.delete(entity);
    }

public LiveData<List<StudentEntity>> getListLiveData_model()
{
    return listLiveData_model;
}
 }
