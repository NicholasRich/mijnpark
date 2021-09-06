package com.boyang.landsense.common.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLandSense is a Querydsl query type for LandSense
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLandSense extends EntityPathBase<LandSense> {

    private static final long serialVersionUID = -258014703L;

    public static final QLandSense landSense = new QLandSense("landSense");

    public final NumberPath<Long> ageCats = createNumber("ageCats", Long.class);

    public final BooleanPath alone = createBoolean("alone");

    public final NumberPath<Long> beauty = createNumber("beauty", Long.class);

    public final NumberPath<Long> benches = createNumber("benches", Long.class);

    public final BooleanPath biking = createBoolean("biking");

    public final NumberPath<Long> biodiversity = createNumber("biodiversity", Long.class);

    public final BooleanPath children = createBoolean("children");

    public final StringPath contributor = createString("contributor");

    public final NumberPath<Long> crowded = createNumber("crowded", Long.class);

    public final BooleanPath dutch = createBoolean("dutch");

    public final NumberPath<Long> education = createNumber("education", Long.class);

    public final NumberPath<Long> facilities = createNumber("facilities", Long.class);

    public final NumberPath<Long> flowers = createNumber("flowers", Long.class);

    public final NumberPath<Long> fotoTowardsPointCompass = createNumber("fotoTowardsPointCompass", Long.class);

    public final NumberPath<Long> garbage = createNumber("garbage", Long.class);

    public final NumberPath<Long> gender = createNumber("gender", Long.class);

    public final StringPath geometry = createString("geometry");

    public final NumberPath<Long> gpsAccuracy = createNumber("gpsAccuracy", Long.class);

    public final StringPath id = createString("id");

    public final NumberPath<Double> indicator = createNumber("indicator", Double.class);

    public final BooleanPath jogging = createBoolean("jogging");

    public final NumberPath<Double> latActual = createNumber("latActual", Double.class);

    public final NumberPath<Double> latSite = createNumber("latSite", Double.class);

    public final NumberPath<Long> lawns = createNumber("lawns", Long.class);

    public final NumberPath<Long> lively = createNumber("lively", Long.class);

    public final NumberPath<Double> longActual = createNumber("longActual", Double.class);

    public final NumberPath<Double> longSite = createNumber("longSite", Double.class);

    public final BooleanPath moreInv = createBoolean("moreInv");

    public final NumberPath<Long> nature = createNumber("nature", Long.class);

    public final NumberPath<Long> natveg = createNumber("natveg", Long.class);

    public final NumberPath<Long> noisy = createNumber("noisy", Long.class);

    public final NumberPath<Long> othParks = createNumber("othParks", Long.class);

    public final NumberPath<Long> paths = createNumber("paths", Long.class);

    public final StringPath photos = createString("photos");

    public final NumberPath<Long> play = createNumber("play", Long.class);

    public final NumberPath<Long> relaxing = createNumber("relaxing", Long.class);

    public final BooleanPath relaxingY = createBoolean("relaxingY");

    public final NumberPath<Long> safe = createNumber("safe", Long.class);

    public final NumberPath<Long> shrubs = createNumber("shrubs", Long.class);

    public final NumberPath<Long> siteId = createNumber("siteId", Long.class);

    public final StringPath skipReason = createString("skipReason");

    public final BooleanPath socialising = createBoolean("socialising");

    public final NumberPath<Long> sports = createNumber("sports", Long.class);

    public final DateTimePath<java.util.Date> timeSubmitted = createDateTime("timeSubmitted", java.util.Date.class);

    public final NumberPath<Long> tranquil = createNumber("tranquil", Long.class);

    public final NumberPath<Long> trees = createNumber("trees", Long.class);

    public final NumberPath<Long> veget = createNumber("veget", Long.class);

    public final BooleanPath visitDaily = createBoolean("visitDaily");

    public final NumberPath<Long> visitFreq = createNumber("visitFreq", Long.class);

    public final BooleanPath walking = createBoolean("walking");

    public QLandSense(String variable) {
        super(LandSense.class, forVariable(variable));
    }

    public QLandSense(Path<? extends LandSense> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLandSense(PathMetadata metadata) {
        super(LandSense.class, metadata);
    }

}

