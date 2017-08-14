## 离线报表

#### Compile: 
> #####  sbt clean assembly

#### Config:
> <pre> 
> app {
>   spark {
>     master = "local[*]"
>   }
> 
>   mysql {
>     url  = "jdbc:mysql://172.16.25.26:3306/premiummad_dev?useUnicode=true&characterEncoding=utf8&autoReconnect=true"
>     user = "root"
>     pwd  = "tomcat2008"
>   }
> 
>   log.path {
>     media_bid  = "/madssp/bidlogs/media_bid"
>     dsp_bid    = "/madssp/bidlogs/dsp_bid"
>     impression = "/madssp/bidlogs/impression"
>     click      = "/madssp/bidlogs/click"
>   }
> 
>   table = {
>     media {
>       base     = "mad_report_media"
>       location = "mad_report_media_location"
>     }
> 
>     dsp {
>       base     = "mad_report_dsp"
>       location = "mad_report_dsp_location"
>       media    = "mad_report_dsp_media"
>     }
> 
>     policy {
>       base     = "mad_report_policy"
>       location = "mad_report_policy_location"
>     }
>   }
>  
>   inserts = ["media", "dsp", "policy"]
> }
> </pre>