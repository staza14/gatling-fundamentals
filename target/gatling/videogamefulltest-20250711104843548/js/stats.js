var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "7",
        "ok": "2",
        "ko": "5"
    },
    "minResponseTime": {
        "total": "1000",
        "ok": "1000",
        "ko": "15271"
    },
    "maxResponseTime": {
        "total": "24883",
        "ok": "4965",
        "ko": "24883"
    },
    "meanResponseTime": {
        "total": "13223",
        "ok": "2983",
        "ko": "17319"
    },
    "standardDeviation": {
        "total": "7300",
        "ok": "1983",
        "ko": "3783"
    },
    "percentiles1": {
        "total": "15428",
        "ok": "2983",
        "ko": "15499"
    },
    "percentiles2": {
        "total": "15506",
        "ok": "3974",
        "ko": "15513"
    },
    "percentiles3": {
        "total": "22072",
        "ok": "4767",
        "ko": "23009"
    },
    "percentiles4": {
        "total": "24321",
        "ok": "4925",
        "ko": "24508"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "t ≥ 800 ms <br> t < 1200 ms",
    "count": 1,
    "percentage": 14
},
    "group3": {
    "name": "t ≥ 1200 ms",
    "count": 1,
    "percentage": 14
},
    "group4": {
    "name": "failed",
    "count": 5,
    "percentage": 71
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.28",
        "ok": "0.08",
        "ko": "0.2"
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
        "total": "5",
        "ok": "0",
        "ko": "5"
    },
    "minResponseTime": {
        "total": "15271",
        "ok": "-",
        "ko": "15271"
    },
    "maxResponseTime": {
        "total": "24883",
        "ok": "-",
        "ko": "24883"
    },
    "meanResponseTime": {
        "total": "17319",
        "ok": "-",
        "ko": "17319"
    },
    "standardDeviation": {
        "total": "3783",
        "ok": "-",
        "ko": "3783"
    },
    "percentiles1": {
        "total": "15499",
        "ok": "-",
        "ko": "15499"
    },
    "percentiles2": {
        "total": "15513",
        "ok": "-",
        "ko": "15513"
    },
    "percentiles3": {
        "total": "23009",
        "ok": "-",
        "ko": "23009"
    },
    "percentiles4": {
        "total": "24508",
        "ok": "-",
        "ko": "24508"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
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
    "count": 5,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.2",
        "ok": "-",
        "ko": "0.2"
    }
}
    },"req_authenticate-ea80a": {
        type: "REQUEST",
        name: "Authenticate",
path: "Authenticate",
pathFormatted: "req_authenticate-ea80a",
stats: {
    "name": "Authenticate",
    "numberOfRequests": {
        "total": "2",
        "ok": "2",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1000",
        "ok": "1000",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "4965",
        "ok": "4965",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "2983",
        "ok": "2983",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1983",
        "ok": "1983",
        "ko": "-"
    },
    "percentiles1": {
        "total": "2983",
        "ok": "2983",
        "ko": "-"
    },
    "percentiles2": {
        "total": "3974",
        "ok": "3974",
        "ko": "-"
    },
    "percentiles3": {
        "total": "4767",
        "ok": "4767",
        "ko": "-"
    },
    "percentiles4": {
        "total": "4925",
        "ok": "4925",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "t ≥ 800 ms <br> t < 1200 ms",
    "count": 1,
    "percentage": 50
},
    "group3": {
    "name": "t ≥ 1200 ms",
    "count": 1,
    "percentage": 50
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.08",
        "ok": "0.08",
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
