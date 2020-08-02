<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="tree">
	<ul style="padding-left: 0px;" class="list-group" >
		<li class="list-group-item tree-closed" id="index-1"><a class="index-color"
			href="${APP_PATH }/main" id="index-10"><i
				class="glyphicon glyphicon-dashboard"></i> 控制面板</a>
		</li>
		<li class="list-group-item tree-closed" id="index-2"><span><i
				class="glyphicon glyphicon glyphicon-tasks"></i> 权限管理 <span
				class="badge" style="float: right">3</span></span>
			<ul style="margin-top: 10px; display: none;" id="index-20">
				<li style="height: 30px;"><a class="index-color"
					href="${APP_PATH }/goodsCategory/index" id="index-21"><i
						class="glyphicon glyphicon-user"></i> 商品维护(未开发)</a>
				</li>
				<li style="height: 30px;"><a  class="index-color" href="#" id="index-22"><i
						class="glyphicon glyphicon-king"></i> 角色维护(未开发)</a>
				</li>
				<li style="height: 30px;"><a class="index-color" href="#" id="index-23"><i
						class="glyphicon glyphicon-lock"></i> 许可维护(未开发)</a>
				</li>
			</ul>
		</li>
		<li class="list-group-item tree-closed" id="index-3"><span><i
				class="glyphicon glyphicon-ok"></i> 业务审核 <span class="badge"
				style="float: right">3</span></span>
			<ul style="margin-top: 10px; display: none;" id="index-30">
				<li style="height: 30px;"><a class="index-color" href="#"><i
						class="glyphicon glyphicon-check"></i> 实名认证审核(未开发)</a>
				</li>
				<li style="height: 30px;"><a class="index-color" href="#" id="index-31"><i
						class="glyphicon glyphicon-check"></i> 广告审核(未开发)</a>
				</li>
				<li style="height: 30px;"><a class="index-color" href="#" id="index-32"><i
						class="glyphicon glyphicon-check"></i> 商品审核(未开发)</a>
				</li>
			</ul>
		</li>
		<li class="list-group-item tree-closed" id="index-4"><span><i
				class="glyphicon glyphicon-th-large"></i> 业务管理 <span class="badge"
				style="float: right ">7</span></span>
			<ul style="margin-top: 10px;display: none;" id="index-40">
				<li style="height: 30px;"><a class="index-color" href="#" id="index-41"><i
						class="glyphicon glyphicon-picture"></i> 资质维护(未开发)</a>
				</li>
				<li style="height: 30px;"><a class="index-color" href="#" id="index-42"><i
						class="glyphicon glyphicon-equalizer"></i> 分类管理(未开发)</a>
				</li>
				<li style="height: 30px;"><a class="index-color" href="#" id="index-43"><i
						class="glyphicon glyphicon-random"></i> 流程管理(未开发)</a>
				</li>
				<li style="height: 30px;"><a class="index-color" href="#" id="index-44"><i
						class="glyphicon glyphicon-hdd"></i> 广告管理(未开发)</a>
				</li>
				<li style="height: 30px;"><a class="index-color" href="#" id="index-45"><i
						class="glyphicon glyphicon-comment"></i> 消息模板(未开发)</a>
				</li>

				<li style="height: 30px;"><a class="index-color"
					href="${APP_PATH }/goodsCategory/index" 
					id="index-46"><i class="glyphicon glyphicon-list"></i> 商品分类 </a>
				</li>
				<li style="height: 30px;"><a class="index-color" href="${APP_PATH }/memberManager/index" id="index-47"><i
						class="glyphicon glyphicon-tags"></i> 会员管理</a>
				</li>
			</ul>
		</li>
		<li class="list-group-item tree-closed"><a class="index-color" href="#" id="index-5"><i
				class="glyphicon glyphicon-list-alt"></i> 参数管理(未开发)</a>
		</li>
	</ul>
</div>