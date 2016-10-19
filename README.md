## springMVC Mybatis Shiro 开发的带会员观看权限的视频站管理系统
### 演示站 [java.licyun.com/movie](http://java.licyun.com/movie)
### 项目简介
- 使用springMVC Mybatis Maven框架开发的权限认证管理系统,shiro验证用户观看角色和权限,MVC interceptor拦截管理员登录
前台使用bootstrap构建，配置使用alibaba数据源,log4j生成日志和debug, AOP事务管理。
视频播放器使用ckPlayer,视频源ID和解析使用优酷(本站视频仅作测试用，如有侵权可联系本站删除)。

### 功能介绍
- 该系统分为2个角色，用户和管理员
- 未登录用户能观看免费视频，登录用户能观看用户视频，用户联系管理员开通vip用户后能观看vip视频，开通vipplus权限后能观看黄金vip视频，用户还可以修改个人信息和头像
- 管理员能修改用户信息，为用户赋予观看权限，添加视频和修改视频

### 系统结构
- controller:控制层 admin user 和video 的请求转发处理
- dao: 数据接口层，与mybatis的mapping映射文件对应
- interceptor: 拦截层，配置管理员未登录时不允许访问其他页面，通过session判断并跳转到登录页
- model: 实体层, user用户，userRole用户角色, UserPermission用户权限, UserPR用户角色权限结合的实体,video视频
- service: 服务层，MessageService和UserService封装了用户管理员和留言的一些业务逻辑处理。
- shiro: apache的开源组件，这里用来对用户赋予角色和授予权限
- util: 工具层，UploadImg图片上传，Validate输入表单验证及错误返回。

### 分页说明
- 分页数据使用select  limit start, size 查询出指定的数据,通过controller的responsive返回List<Video>的json数据，
前台通过ajax得到json数据后循环输出到id为videos的dom结点上。其中要注意的是页面边界的问题，currentPage
记录当前页面数，当到达第一页或者最后一页时，currentPage不变。

### 暂时想到这么多，有坑以后再填



