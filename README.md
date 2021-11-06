# Lambda-Matcher-gRPC

### Description: The goal of this project was to write a gRPC service that could find log messages before or after a certain time-stamp with a given delta and deploy it on AWS Lambda.

### AWS API Gateway Link

The API is deployed using the following link:
https://gfpvb950hk.execute-api.us-east-2.amazonaws.com/prod/timestampfinder

It contains a "timestampfinder" with a POST method created for the implementation of a LAMBDA function using a RESTful API.

One can also use the RESTApi using a REST client like POSTMAN.
You can install POSTMAN using [this](https://www.postman.com/downloads/) link.

#### Sample Input Parameters:

```
{
  "timestamp": "17:51:52.790",
  "delta": "0:0:01"
}
```
The above parameters are in a RAW JSON form.

#### cURL request:
A cURL request can be sent using command line or using any online cURL tool ([example](https://reqbin.com/curl))
```
curl --location --request POST 'https://gfpvb950hk.execute-api.us-east-2.amazonaws.com/prod/timestampfinder' \
--header 'Content-Type: application/json' \
--data-raw '{
  "timestamp": "17:51:52.790",
  "delta": "0:0:01"
}'
```


#### Sample Response:

The response is in the following JSON form with timestamps as the keys and log messages as values.
```
{"17:51:51.018": "_j}YW{Q~aur=Rcj=('I7BZ6sN9qae3af0U6vzOLN3iaX9z;/%v~tBA(eM", "17:51:51.033": "E<(K@;nB`gA5hS6pD5pce2ae1ae0U7lcf1N5gcg3`)l)}u?Vf|", "17:51:51.092": "7jsT%m?k#*:kFPHikxKkQce3ce3V8kN8tbe2E9rLNyO7'T)dQ(*p27JrYtxP", "17:51:51.107": "[ZP2y,?(%Gq|P<_;%olAzFfI6(x.?tcf0B7tI7vT9rce3bf3sdQ{wHCHCi!b84|ulda[Hi?9bua;[\"", "17:51:51.123": ">gl;[TbKw&\"fbg1be0S9pcf3cf2bg2af1ag2Z@,5.4:t4)+Y", "17:51:51.152": "NA{Y>rae2af1O7hbe2D6oP9jHw@rEk", "17:51:51.212": "c0?oN){`5o^x>6x+l3A;6t~AGO;;-ae0X8rbg0I9iM7iB6fL6qU6icg3/UH$GCD?4JU310}yNWkBcl@y1K'>/", "17:51:51.227": "VGzr`RYOaY`k(voXhl1'Q6fcg2af0Y7jaf3\">RrT(^TDzmXe2JMCwpu", "17:51:51.374": "rjMs@-0b~SQLW7pS7vbe0af2cf3S5tbe0y(gtQS8;ai'd", "17:51:51.394": "^*h|Xj+5</}ML{ce2bf3ae2bf2bf2S7nI6lcf0T9uuSII9)e17e&Iu?", "17:51:51.442": "u`z0?;'CtWgI+&y7W36zZyxJ|(cg2F6faf0U9tce2A6tA{&$-iWOTK)e:ZFQ#sy[2'01X[", "17:51:51.457": "i}:f~qrgS`[Yaf1Y7ncg1be1ag1cf2R6hP9rY7qwi$px;2\\a1Of", "17:51:51.517": "\"8\\F{W-<&D9L8bf2ag0be0H5nQ7w`\"2EkpDA@xiTG", "17:51:51.628": "QAPW1@|I$9#W#FSxbe3bf1Z6mcg3S7lag1K9}DaD#{}9jZL8~W", "17:51:51.738": "l/)el+`NxA9Sc]ow?j|&OMBXxQ{ag1ag1cg1bf2af1bg1ag2M8rag1be1ce3\\I;wnG&3w9E,cX00xqcpjI{gQf|", "17:51:51.825": "/U=|!|1xo,{Z|jPL)A\\?cf3N6hcf0af2cg2be3mSJLq}Jj[[fh0*:nPLF&", "17:51:51.874": "ye~I<<T9jP5pcg0bg3M6n(R<is:", "17:51:52.019": "5i1T>,)YZ!Rui$_D9mae1cg1C9gcg0Y8paf2bf1P8rHnW]G\\UC@xN6AHD", "17:51:52.032": "NjWd\\nZ1Zw,P^PgQ|i23gy?j@Q~XP8sbe2be3be2ag2^)0&xCG-$-64Lb5lctfR)c=06NnC", "17:51:52.106": "Z0ZgT15?ic(qWEdNce3E8haf2U8rbe0G9v&[3'Y5h,p\\l(s", "17:51:52.140": "(''=+Le*Z9qD8paf2be1F9lS%.9?P4L", "17:51:52.157": "E[i*7sh8^C9raf0H5kag0bf0+WVNyi'cJ", "17:51:52.263": "\"*MhN\"KNu[3I'o9%Ctn~eejaf1M8ice1ae3bg3Q8vE5obf1q<{e{?V{l7HdI)!$,$\"Nt>C", "17:51:52.408": "4!B|M\"lR(7bUe[[-^Jce2K5rcg1Z9kZ5jJ7mT6rT9iW8vae0I6te!!!_Zu4uh^E/UkJkr", "17:51:52.469": "TgnaLi5<aQ6pS9mce1bf2cg1W~NyhH($p", "17:51:52.515": "I3IK|=bf2ag0bg1bf3bg2g*#*@&", "17:51:52.575": "_Uy0E*MM*&/NRF8pB9gbf3ce3af3V+YFuGkWK^0Zc", "17:51:52.604": "4[5F[>LMP:E.}~_]-B)']xcg2F5ubg0K8kae1bf3B7t'>Q&_=?EZo,n<j9-]a5eLg", "17:51:52.706": "68#zjWi],.%Z`H5af3cg0ce0Q9gY6scg0\\85(\"]L7;v/&gy,", "17:51:52.746": "&\"\"2Tbc=7T6iU6oce1bf2V7wG6nx*3dPA,:,", "17:51:52.820": "i%iM8sD)AT8_zGtIa2dKHsPxH7'S5bg0H7nag3E7rN8wWt?PR>WL;h0y=,R,Z=[fxElr#Q\\-'", "17:51:53.021": "*vkJqJh$;ytG8rZ9sag3cg3P9ncf1ag2H9fag0P_2ZU12DBiI", "17:51:53.080": "=PH>/fm/<C[f}}yc~qf!;k<=9fp\\Cpbf2Z6lce2cf1cg2V6s0K%BAG>H>T$SGV9>`2S!%B]yZtM<Z{", "17:51:53.094": "A'`}g#cf1ce1P8jL5ibf0ug?`!+", "17:51:53.259": "_GVn&QV?bk`1W)+$C7HqH[c0\\Xkce0G5pP5hU7rJ7k'$UC'J|U&;'m))hjxo(A[t(It3d", "17:51:53.310": "Z+<txB8/E[/mYdU',%P6fbg0bg2ae0af2H7i@xgrAX;`RG,C-M^k!j", "17:51:53.324": "2Pwm,+s(>o\"|cw`R5pag1J9uO6kN7gag1af1a:+YzYbkf{vn>]1", "17:51:53.381": "Q_*0=p1l$2JpPwvf|be3cf0L6ocf1Y9gY6gbe3J6pB8hS8gX9mbf2cf31P?!/itp:Kd~/K3Jy", "17:51:53.426": "Ipo:i?tW/Ao/H#5]vFPbg0X5iF8wP6jbg2>0#5+n4Po--\\V|poGX*", "17:51:53.441": "X%;aP5XCO:q1SzxKL$$V;5BqZbg1B8wX5oI5fO6pE9wE9sF6sK5vcg0[}c7P9?:CmAxuHC6@\",&__Gfk", "17:51:53.474": "9P#qSZ'%ce0bg1Y9iD9fC5jW6rxzB.1", "17:51:53.646": "YOJ]y={,qVgmur'a$TNyWag0af0B9tL7jP5faxjilDK;Ywq5d$0q$DFb1", "17:51:53.690": "7EnxYL>gEI#;]}O24qXWtdPycP7tce1X7sA6qbe2S5jA9jMK=w,L`K0Pg~fTbV#~8p<&MEq", "17:51:53.719": "z$Qy}W,c2`CZ8oce1F6rbg0ae0cf2S5vH5k**5a[IJiy!'", "17:51:53.844": "?z#-0-!o4<C>9-cf0R7jG6hD9lB7rce3iu%TGGd+GtAd#h", "17:51:53.890": "pe]>lCce2K5iae1ag1be2ce2Uuvr7P"}

```

## Prerequisites and Installation
1. Clone the repository into your system.
2. Install [Simple Build Toolkit](https://www.scala-sbt.org/1.x/docs/index.html) (SBT) to build and run the repository.
3. Install and Configure [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html).

## Project Workflow

This workflow describes the entire communication taking place between various entities in the project, hopefully, giving a clear understanding of working of the architecture of the system.

![Alt text](doc/workflow.jpg?raw=true "gRPC_flowchart")

###Lambda function

The following AWS Lambda function searches if the time stamp is present in log data and then execute pattern matching to retrieve the desired logs.
```
import json
import boto3
from datetime import *
from bisect import *
import re

s3 = boto3.client('s3')

def lambda_handler(event, context):
    
    bucket = 'cc3logfile'
    key = 'input/LogFileGenerator_1000.log'
    event_body = json.loads(event["body"])
    timestamp = event_body["timestamp"]
    timestamp = timestamp[0:-4]
    delta = event_body["delta"]
    delta = int(delta[-2:])
    t = datetime.strptime(timestamp,'%H:%M:%S')
    change = timedelta(seconds=delta)
    t0 = (t - change).time()
    t1 = (t + change).time()
    
    
    log_data = ""
    try:
        data = s3.get_object(Bucket=bucket, Key=key)
        log_data = data['Body'].iter_lines()
        
        
    except Exception as e:
        print(e)
        raise 
    og_timelist = []
    timestamp_list = []
    logs_list = []
    for lines in log_data:
        line = lines.decode('utf-8')
        items = line.split(" ")
        logs = items[5]
        times = items[0]
        og_timelist.append(times)
        time_s = datetime.strptime(times[0:-4],'%H:%M:%S').time()
    
        timestamp_list.append(time_s)
        logs_list.append(logs)
        
     
    i0 = bisect_left(timestamp_list, t0)
    i1 = bisect_right(timestamp_list, t1)
    print(i0)
    print(i1)
    timestamp_list = timestamp_list[i0:i1]
    og_timelist = og_timelist[i0:i1]
    logs_list = logs_list[i0:i1]
    
    final_list = []
    timestamp_final = []
    i=0
    for logmsgs in logs_list:
        i=i+1
        match = re.search('([a-c][e-g][0-3]|[A-Z][5-9][f-w]){5,15}', logmsgs)
        if match:
            final_list.append(logmsgs)
            timestamp_final.append(str(og_timelist[i]))
            
    #print("Timestamp final", len(timestamp_final))
    #print("final_list", len(final_list))
    res = dict(zip(timestamp_final, final_list))
    
    response = None
    if res:
        response = {
            "statusCode": 200,
            "headers": {"Content-Type": "application/grpc-proto"},
            "body": json.dumps(res)
        }
    else:
        response = {
            "statusCode": 404,
            "headers": {"Content-Type": "application/grpc-proto"},
            "body": json.dumps([])
        }
        
    return response
```