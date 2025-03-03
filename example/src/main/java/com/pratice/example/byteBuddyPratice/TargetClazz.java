package com.pratice.example.byteBuddyPratice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TargetClazz {

    public String speak(){
      log.info("浜辺美波が好きです!!!!");
      int n = 1 / 0;
      return "chiikawa!";
    }
}
