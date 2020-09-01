### SSM(Spring SpringMVC Mybatis)框架开发简易视频站管理系统
- 演示站 [movie.licyun.com](https://movie.licyun.com)
- 管理员登录界面：[movie.licyun.com/admin/](https://movie.licyun.com/admin/)
- 管理员帐号:licyun@qq.com 密码：123456

### 技术选择
- SSM(Spring SpringMVC Mybatis)框架
- Shiro框架 控制会员角色和视频播放权限
- Spring MVC interceptor 拦截器控制管理员登陆
- MessageSource 实现国际化消息资源
- RESTFUL 格式传输参数
- bootstrap 简陋构建前台
- ckPlayer 播放器播放视频(本站视频仅作测试用，如有侵权可联系本站删除)。

### 项目简介
#### 该系统分为2个角色，用户和管理员
1. 未登录用户能观看免费视频，登录用户能观看普通视频，用户升级为vip用户后能观看vip视频，开通vipplus权限后能观看黄金vip视频
1. 管理员能修改用户信息，为用户赋予观看权限，添加视频和修改视频

### 系统结构
- controller:控制层 admin user 和video 的请求转发处理
- dao: 数据接口层，与mybatis的mapping映射文件对应
- interceptor: 拦截层，配置管理员未登录时不允许访问其他页面，通过session判断并跳转到登录页
- model: 实体层, user用户，userRole用户角色, UserPermission用户权限, UserPR用户角色权限结合的实体,video视频
- service: 服务层，MessageService和UserService封装了用户管理员和留言的一些业务逻辑处理。
- shiro: apache的开源组件，这里用来对用户赋予角色和授予权限
- util: 工具层，UploadImg图片上传，Validate输入表单验证及错误返回。

### 数据库权限表说明

- userpermission用户权限表

| id | email | permission |
| --- | --- | --- |
| 主键 | 邮箱 | 权限(user:user拥有普通权限，user:vipplus拥有视频点播权限) |

- userrole 用户角色表

| id | role_name | email | admin |
|---|---|---|---|
| 主键 | 角色名(user为普通用户，vip为会员用户) | 邮箱 | 是否管理员(true为管理员) |

- user用户表

| id | username | password | email | imgurl |
|---|---|---|---|---|
| 主键 | 用户名 | 密码 | 邮箱 | 图片链接 |

- video 视频表

| id | name | director | starring | type | area | data | vid | img | playtype | description|
|---|---|---|---|---|---|---|---|---|---|---|
| 主键 | 视频名 | 导演 | 演员 | 类型 | 地区 | 日期 | 视频id | 图片 | 播放类型 | 描述 |




