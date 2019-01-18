package com.stackroute.MuzixApp.service;

import com.stackroute.MuzixApp.domain.Track;
import com.stackroute.MuzixApp.exception.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService  {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> displayTrack();

    public Track updateTrack(Track track);


    public boolean deleteTrack(int trackId) throws TrackNotFoundException;

}
