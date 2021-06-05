package com.example.myroomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentRepo
{
LiveData<List<StudentEntity>> listLiveData;
StudentDataBase studentDataBase;
public StudentRepo(Application application){
    studentDataBase=StudentDataBase.getDataBase(application);
    listLiveData=studentDataBase.studentsDao().retrive();

}
//insert
public class AsynckTaskForInsert extends AsyncTask<StudentEntity,Void,Void>{

    @Override
    protected Void doInBackground(StudentEntity... studentEntities) {
        studentDataBase.studentsDao().insert(studentEntities[0]);
        return null;
    }
}
//update
public class AsynckTaskForUpdate extends AsyncTask<StudentEntity,Void,Void>{

    @Override
    protected Void doInBackground(StudentEntity... studentEntities) {
        studentDataBase.studentsDao().update(studentEntities[0]);
        return null;
    }
}
//delete
public class AsynckTaskForDelete extends AsyncTask<StudentEntity,Void,Void>{

    @Override
    protected Void doInBackground(StudentEntity... studentEntities) {
        studentDataBase.studentsDao().delete(studentEntities[0]);
        return null;
    }
}
public void insert(StudentEntity studentEntity){
     new AsynckTaskForInsert().execute(studentEntity);

}
    public void update(StudentEntity studentEntity){
        new AsynckTaskForUpdate().execute(studentEntity);

    }
    public void delete(StudentEntity studentEntity){
        new AsynckTaskForDelete().execute(studentEntity);

    }

}
