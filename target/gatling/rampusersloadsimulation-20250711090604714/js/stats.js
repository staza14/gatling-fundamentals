var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "480",
        "ok": "480",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "43",
        "ok": "43",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1052",
        "ok": "1052",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "56",
        "ok": "56",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "47",
        "ok": "47",
        "ko": "-"
    },
    "percentiles1": {
        "total": "51",
        "ok": "51",
        "ko": "-"
    },
    "percentiles2": {
        "total": "54",
        "ok": "54",
        "ko": "-"
    },
    "percentiles3": {
        "total": "76",
        "ok": "76",
        "ko": "-"
    },
    "percentiles4": {
        "total": "108",
        "ok": "108",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 479,
    "percentage": 100
},
    "group2": {
    "name": "t ≥ 800 ms <br> t < 1200 ms",
    "count": 1,
    "percentage": 0
},
    "group3": {
    "name": "t ≥ 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    }
},
contents: {
"req_get-all-video-g-6a25e": {
        type: "REQUEST",
        name: "Get all video games",
path: "Get all video games",
pathFormatted: "req_get-all-video-g-6a25e",
stats: {
    "name": "Get all video games",
    "numberOfRequests": {
        "total": "320",
        "ok": "320",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "44",
        "ok": "44",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "159",
        "ok": "159",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "54",
        "ok": "54",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    },
    "percentiles1": {
        "total": "52",
        "ok": "52",
        "ko": "-"
    },
    "percentiles2": {
        "total": "55",
        "ok": "55",
        "ko": "-"
    },
    "percentiles3": {
        "total": "78",
        "ok": "78",
        "ko": "-"
    },
    "percentiles4": {
        "total": "106",
        "ok": "106",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 320,
    "percentage": 100
},
    "group2": {
    "name": "t ≥ 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t ≥ 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8",
        "ok": "8",
        "ko": "-"
    }
}
    },"req_get-specific-ga-03796": {
        type: "REQUEST",
        name: "Get specific game",
path: "Get specific game",
pathFormatted: "req_get-specific-ga-03796",
stats: {
    "name": "Get specific game",
    "numberOfRequests": {
        "total": "160",
        "ok": "160",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "43",
        "ok": "43",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1052",
        "ok": "1052",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "58",
        "ok": "58",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "79",
        "ok": "79",
        "ko": "-"
    },
    "percentiles1": {
        "total": "50",
        "ok": "50",
        "ko": "-"
    },
    "percentiles2": {
        "total": "53",
        "ok": "53",
        "ko": "-"
    },
    "percentiles3": {
        "total": "67",
        "ok": "67",
        "ko": "-"
    },
    "percentiles4": {
        "total": "110",
        "ok": "110",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 159,
    "percentage": 99
},
    "group2": {
    "name": "t ≥ 800 ms <br> t < 1200 ms",
    "count": 1,
    "percentage": 1
},
    "group3": {
    "name": "t ≥ 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "4",
        "ok": "4",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
