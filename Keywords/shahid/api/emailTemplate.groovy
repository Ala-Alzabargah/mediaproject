package shahid.api

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import internal.GlobalVariable

public class emailTemplate {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
	String msg
	int ClipsFailedNum,EpisodesFailedNum,MoviesFailedNum=0
	int total
	def public String createTemplate() {
		List<FailedResult> ClipsFailedResult = ClipsFailedPatch.getClipsFailedInstance().getClipsFailedResults()
		List<FailedResult> EpisodesFailedResult = EpisodesFailedPatch.getEpisodesFailedInstance().getEpisodesFailedResults()
		List<FailedResult> MoviesFailedResult = MoviesFailedPatch.getMoviesFailedInstance().getMoviesFailedResults()
		ClipsFailedNum=ClipsFailedResult.size()
		EpisodesFailedNum=EpisodesFailedResult.size()
		MoviesFailedNum=MoviesFailedResult.size()
		total=ClipsFailedNum+EpisodesFailedNum+MoviesFailedNum

		//Header
		msg = "<html>"
		msg += "<head> "
		msg += '    </head>'
		msg += '<body>'
		msg += ' <style>'
		msg += ' table {border-collapse: collapse;border-spacing: 0;}'
		msg += '.button {position: relative;background-color: #0096FF;border: none;font-size: 12px; color:white; padding: 8px;width: 100px;text-align: center; transition-duration: 0.4s;text-decoration: none;overflow: hidden;cursor: pointer;}'
		msg += '  th, td {text-align: left;  padding: 8px;}tr:nth-child(even){background-color: #f2f2f2}th {background-color: #343a40;color: white;} '
		msg +=' .long-text{word-break: break-word;width: 20vw;max-height: 100px;overflow-y: auto;}'
		msg += ' </style>'
		msg += '<center><img src="http://competition.mbc.net/shahid-api-monitoring/assets/images/logo.png?v=1" class="img-fluid centered" alt="Responsive image"></center></br>'
		msg += '<center><h4>Test Suite Results / Time & Date : '+LocalDateTime.now().format(formatter)+'</h4></center>'
		msg +='<center> <style> table, th,td,tr {border: 1px solid black;}table,details {table-layout: fixed ;width:100% ;}details { border-spacing: 10px;border: 1px solid black;}td,tr {padding: 10px;}</style>'
		msg += '  <table style="text-align:center">'
		msg += ' <tr style="background-color:black"  >'
		//Table Header
		msg +='  <th style="color:white">API</th> <th style="color:white">Status</th><th style="color:white">Asset ID</th> <th colspan="2" style="color:white">Causes Of Failure</th> <th style="color:white"colspan="3">Responses</th></tr>'
		//Table Cells
		if(ClipsFailedNum>0) {
		setTableValue(ClipsFailedResult,'Clips')}
		
		if(EpisodesFailedNum>0) {
			setTableValue(EpisodesFailedResult,'Episodes')}
		
		if(MoviesFailedNum>0) {
			setTableValue(MoviesFailedResult,'Movies')}
		
		//Result part
		msg +='<th colspan="8" style="background-color:gray" ><center>Results</center></th> <tr><th scope="col" colspan="2">Clips Failed :<h style="color: red"> '+ClipsFailedNum+'</h><th scope="col" colspan="2">Episodes Failed :<h style="color: red"> '+EpisodesFailedNum+'</h></th> <th scope="col" colspan="2">Movies Failed :<h style="color: red"> '+MoviesFailedNum+'</h> </th><th scope="col" colspan="2" >Total : '+total+'</th></tr>'
		msg += '</table>'
		msg +='</center>'
		msg +='</body></html>'
		return msg
	}

	def setTableValue(List<FailedResult> FailedResult,String assetType) {
		int FailedNum=FailedResult.size()
		println "resultsList[].size :: "+FailedResult.size()
		for (int i = 0; i < FailedNum; i++) {

			if(i==0) {
				msg += '<tr> <th rowspan='+FailedNum+'>'+assetType+'</th>'
			}else {
				msg += '<tr>'
			}

			//Asset ID
			msg += '<td style="color:#FF0000"><center><b>&#x2715;</b></center></td><td >'+FailedResult[i].assetID+'</td>'
			//Causes Of Failure
			msg += ' <td colspan="2">'
			if(FailedResult[i].playoutStatus!=null && FailedResult[i].playoutStatus!='-') {
				msg += '<li>'+FailedResult[i].playoutStatus+'</li>'
			}
			if(FailedResult[i].urlStatus!=null && FailedResult[i].urlStatus!='-') {
				msg += '<li>'+FailedResult[i].urlStatus+'</li>'
			}
			if(FailedResult[i].DRMStatus!=null && FailedResult[i].DRMStatus!='-') {
				msg += '<li>'+FailedResult[i].DRMStatus+'</li>'
			}
			msg += ' </td>'

			msg += ' <td colspan="3">'

			if(FailedResult[i].playoutResponse!=null && FailedResult[i].playoutResponse!='-') {
				msg += '<details><summary>See Playout Response</summary><p class="long-text" >'+FailedResult[i].playoutResponse+'</p></details>'
			}
			if(FailedResult[i].urlValue!=null && FailedResult[i].urlValue!='-') {
				msg += '<details><summary>See URL Value</summary><p class="long-text" >'+FailedResult[i].urlValue+'</p></details>'
			}
			if(FailedResult[i].DRMResponse!=null && FailedResult[i].DRMResponse!='-') {
				msg += '<details><summary>See DRM Response</summary><p class="long-text" >'+FailedResult[i].DRMResponse+'</p></details>'
			}
			msg += ' </td>'
			msg += ' </tr>'

		}

	}
}
