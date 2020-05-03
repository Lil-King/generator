<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout>
	<jsp:body> 
	<gd:Navgation addlink="csc/systemconfig/add.do" addr="基础信息 &gt; 系统配置 "></gd:Navgation>
	<div class="data_model">
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="csc/systemconfig/datalist.do"
									data-ajax="true" data-ajax-begin="loadBegin"
									data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
									data-ajax-loading="#loading_img" data-ajax-method="POST"
									data-ajax-mode="replace" data-ajax-update="#data_list"
									novalidate="novalidate">
							<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" />
					        <div class="data_cont_wrap_list">
								<table class="wc100">
									<tbody>
										<tr>
											<th class="w60">企业名称
											</th>					
											<td class="w15per">
												<input class="inp_t inp_w180" name="qymc" id="qymc" />
											</td>
											<td>
												<span class="btn btn_pub">
													<input type="submit" id="btn_search" value="查询" />
												</span>
												<span class="ml10 btn btn_pub">
													<a href="csc/systemconfig/list.do">重置</a>
												</span>
											</td>
										</tr>
									 </tbody>
							 	 </table>
					        </div>
				     	</form>
				 	</div>
					<div class="data_model wc100 data_list_wrap" id="data_list">
					    <%@ include file="data_list.jsp"%>
				 	</div>
		 		</td>
		 	</tr>
	 	</table>
 	</div>
	<img class="dn" id="loading_img" src="img/loading.gif" alt="loading" />
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript">
		$(function() {
			
			$('#btn_add').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'add_page',
					title : '添加系统配置 ',
					width : '800px',
					height : '300px'
				});
				return false;
			});

			$('.update').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'update_page',
					title : '修改系统配置 ',
					width : '800px',
					height : '300px'
				});
				return false;
			});

			$('.view').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'view_page',
					title : '查看系统配置 ',
					width : '800px',
					height : '300px'
				});
				return false;
			});

		});
	</script>
	</jsp:body>
</gd:Layout>
