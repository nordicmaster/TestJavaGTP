package com.example.demo;

public class GTPItem {

    public String id;
    public String name;
    public int instruments;
    public int tracks;
    public int tacts;
    public int  tempo;
    public String tonality;
    public String signature;
    public boolean gtp_finished;
    public boolean text_finished;
    public boolean recorded;
    public double length;

    public GTPItem(String id,
                   String name,
                   int instruments,
                   int tracks,
                   int tacts,
                   int tempo,
                   String tonality,
                   String signature,
                   boolean gtp_finished,
                   boolean text_finished,
                   boolean recorded) {
        this.id = id;
        this.name = name;
        this.instruments = instruments;
        this.tracks = tracks;
        this.tacts = tacts;
        this.tempo = tempo;
        this.tonality = tonality;
        this.signature = signature;
        this.gtp_finished = gtp_finished;
        this.text_finished = text_finished;
        this.recorded = recorded;
        this.length = tempo == 0 ? 0 : 2 * tacts * 120 / tempo;
    }

}