<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap">
	    <div class="view_data">
	        <table class="wc100">
				<tbody>
					<tr>
						<th class="w10per">企业名称</th>
						<td class="w35per">
							${model.qymc}
						</td>
						<th class="w10per">负责人</th>
						<td>
							${model.fzr}
						</td>
					</tr>
					<tr>
						<th>业务咨询</th>
						<td>
							${model.ywzxsj}
						</td>
						<th>投诉建议</th>
						<td>
							${model.tsjysj}
						</td>
					</tr>
					<tr>
						<th>安装</th>
						<td>
							${model.azsj}
						</td>
						<th>维修</th>
						<td>
							${model.wxsj}
						</td>
					</tr>
					<tr>
						<th>拆/移机</th>
						<td>
							${model.cyjsj}
						</td>
						<th>退/换机</th>
						<td>
							${model.thjsj}
						</td>
					</tr>
					<tr>
						<th>鉴定/监测</th>
						<td>
							${model.jdjcsj}
						</td>
						<th>其他</th>
						<td>
							${model.qtsj}
						</td>
					</tr>
				</tbody>
			</table>      
	    </div>
	    <div class="btn_area">
	        <span class="btn btn_base"><input type="button" id="btn_pclose" value="关闭"></span>
	    </div>
	</div>
</gd:PopLayout> 