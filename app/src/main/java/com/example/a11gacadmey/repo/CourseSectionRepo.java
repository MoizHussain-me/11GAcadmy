package com.example.a11gacadmey.repo;


import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.a11gacadmey.models.CategoryModel;
import com.example.a11gacadmey.models.CourseModel;
import com.example.a11gacadmey.models.CourseSectionModel;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CourseSectionRepo {

    MutableLiveData<List<CourseSectionModel>>
    courseSectionLiveData;
    ArrayList<CourseModel> Dev  = new ArrayList<>();
    MutableLiveData<List<CourseModel>> AllCourseLiveData ;
    FirebaseFirestore db;





    public ArrayList<CourseModel> getCoursesByCategory(String catID){

        db = FirebaseFirestore.getInstance();


        DocumentReference reference = db.collection("Categories").document(catID);

        ArrayList<CourseModel> coursesList = new ArrayList<>();


        db.collection("Courses").whereEqualTo("category", reference).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {



                        for (DocumentSnapshot ds  :  queryDocumentSnapshots.getDocuments()) {


                            coursesList.add(new CourseModel(ds.toObject(CourseModel.class)));

                        }





                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {


                        Log.d("SIZE", "onFailure: "+e.getMessage());


                    }
                });

return coursesList;
    }



    public MutableLiveData<List<CourseModel>> getAllCourses(){

      db = FirebaseFirestore.getInstance();
      AllCourseLiveData = new MutableLiveData<>();


      db.collection("Courses").get()
              .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                  @Override
                  public void onSuccess(QuerySnapshot queryDocumentSnapshots) {


                      for (DocumentSnapshot ds  :  queryDocumentSnapshots.getDocuments()) {


                          Dev.add(new CourseModel(ds.toObject(CourseModel.class)));

                      }

                      AllCourseLiveData.setValue(Dev);



                  }
              }).addOnFailureListener(new OnFailureListener() {
                  @Override
                  public void onFailure(@NonNull Exception e) {

                  }
              });



       return AllCourseLiveData;


    }





   public MutableLiveData<List<CourseSectionModel>> getCourseSection(){
       db = FirebaseFirestore.getInstance();
       courseSectionLiveData = new MutableLiveData<>();
       ArrayList<CourseSectionModel> data = new ArrayList<CourseSectionModel>();

       db.collection("Categories").get()
               .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                   @Override
                   public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                       for(DocumentSnapshot ds : queryDocumentSnapshots.getDocuments())
                       {

     data.add(new CourseSectionModel(ds.getData().get("Name").toString(),getCoursesByCategory(ds.getId())));


                       }


                       courseSectionLiveData.setValue(data);
                   }
               }).addOnCanceledListener(new OnCanceledListener() {
                   @Override
                   public void onCanceled() {
                       Log.d("SIZE", "onFailure: "+"Get Category failed");
                   }
               });
        return courseSectionLiveData;
    }




}
