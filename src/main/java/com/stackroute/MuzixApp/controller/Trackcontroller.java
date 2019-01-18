package com.stackroute.MuzixApp.controller;


import com.stackroute.MuzixApp.domain.Track;
import com.stackroute.MuzixApp.exception.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.exception.TrackNotFoundException;
import com.stackroute.MuzixApp.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1")
public class Trackcontroller {

    private TrackService trackService;

    @Autowired
    public Trackcontroller(TrackService trackService){

        this.trackService=trackService;
    }


    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException{

        ResponseEntity responseEntity;
        try {

            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("created", HttpStatus.CREATED);
        }

        catch (TrackAlreadyExistsException exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;

    }

    @GetMapping("track")
    public ResponseEntity<?> displayTrack(){


        return new ResponseEntity<List<Track>>(trackService.displayTrack(),HttpStatus.OK);
    }

@PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track){

        ResponseEntity responseEntity;

        trackService.updateTrack(track);
        responseEntity=new ResponseEntity<Track>(track,HttpStatus.CREATED);


return responseEntity;

}

@DeleteMapping("track/{trackId}")
public ResponseEntity<?> deleteTrack(@PathVariable("id") int trackId) throws TrackNotFoundException{

        ResponseEntity responseEntity;

        try{

            trackService.deleteTrack(trackId);
            responseEntity=new ResponseEntity<String>("deleted",HttpStatus.OK);

        }
        catch(Exception exception){

            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;

}


}
