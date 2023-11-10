<script setup type="module">

import { onMounted, ref, reactive , toRefs } from 'vue'
import {loadByPage,updateScheduleById,removeScheduleById} from '../api/ScheduleApi'

let schedule = reactive({
   //假数据!
   //本页数据
   data:[
         {id:1,title:'学习java',completed:true},
         {id:2,title:'学习html',completed:true},
         {id:3,title:'学习css',completed:true},
         {id:4,title:'学习js',completed:true},
         {id:5,title:'学习vue',completed:true}
      ], 
   //分页参数
   pageSize:5, // 每页数据条数 页大小
   total:39 ,   // 总记录数
   currentPage:1 // 当前页码
})

//封装数据查询和更新方法
let showdata = (pageSize=5,currentPage=1)=>{
   loadByPage(pageSize,currentPage).then(
      response  =>{
         //加载完,获取axios数据,并赋值
         console.log(response.data.data)
         Object.assign(schedule, response.data.data)
         console.log(schedule)
      }
   )
}


// 1.初始化周期加载数据
onMounted(()=>{
   showdata()
})


// 修改视图是否显示的控制数据
let editVisible = ref(false)
// 定义接收数据的对象
const editForm = reactive({
   id: 0,
   title: '',
   completed: false
})

//自定义标签 编辑标签触发方法
const handleEdit = (row) => {
  // 将要修改的本行数据放在editForm中
  editForm.id=row.id
  editForm.title=row.title
  editForm.completed=row.completed
  // 设置修改对话框显示
  editVisible.value=true
}

// 2. 触发数据修改更新
const handleUpdate =async () => {
   // 发送异步请求,将修改的信息发送给后端
   await updateScheduleById(editForm)
   showdata() //查询新数据
   // 关闭视图
   editVisible.value=false
   
}

//3.触发数据删除
const handleDelete =async (id,title) => {
   // 删除确认
   if(!confirm(`确定删除-${title}-日程`)){
      return 
   }
   // 异步删除数据
   await removeScheduleById(id)
   //查询新数据
   showdata()
}

//4.点击分页触发的方法 page为触发页数
let handlePageChange = (page)=>{
   //点击分页器,会更新数据的页码和页容量,我们再调用分页查询方法即可!
   showdata(undefined,page)
}


</script>

<template>
   <div class="common-layout">
      <el-container>
         <router-link to="/add"><el-button type="primary">添加</el-button></router-link>
      </el-container>
      <el-container>
         <el-main>
            <!-- 表格 -->
            <el-table :data="schedule.data" style="width: 100%">
               <el-table-column label="编号" width="100">
                  <template #default="scope">
                     <div style="display: flex; align-items: center">
                        <span style="margin-left: 10px">{{ scope.row.id }}</span>
                     </div>
                  </template>
               </el-table-column>
               <el-table-column label="学习计划" width="180">
                  <template #default="scope">
                     <div style="display: flex; align-items: center">
                        <span style="margin-left: 10px">{{ scope.row.title }}</span>
                     </div>
                  </template>
               </el-table-column>
               <el-table-column label="是否完成" width="130">
                  <template #default="scope">
                     <div style="display: flex; align-items: center">
                        <el-icon></el-icon>
                        <span style="margin-left: 10px">{{ scope.row.completed ? '完成' : '未完成' }}</span>
                     </div>
                  </template>
               </el-table-column>
               <el-table-column label="其他操作">
                  <template #default="scope">
                     <el-button size="small" @click="handleEdit(scope.row)">编辑</el-button>
                     <el-button size="small" type="danger" @click="handleDelete(scope.row.id,scope.row.title)">删除</el-button>
                  </template>
               </el-table-column>
            </el-table>
            <!-- 分页处理 -->
            <br>
            <div class="pagination">
               <el-pagination background layout="prev, pager, next" 
                  :total="schedule.total"
                  :current-page="schedule.currentPage" 
                  :page-size="schedule.pageSize" 
                  @current-change="handlePageChange" />
            </div>


            <!-- 添加编辑dialog框 -->
            <!-- :visible.sync="editVisible"  获取一个值,通过控制他的true和false进行展示控制-->
            <el-dialog title="编辑任务项" v-model="editVisible" :close-on-click-modal="false">
               <!-- :model='数据对象 应该是一个响应对象'-->
               <el-form label-width="80px">
                  <!-- 绑定数据的key title-->
                  <el-form-item label="标题" prop="title">
                     <el-input v-model="editForm.title" />
                  </el-form-item>
                  <el-form-item label="状态" prop="completed">
                     <!-- 数据是否完成选项-->
                     <el-radio-group v-model="editForm.completed">
                        <el-radio :label="true">已完成</el-radio>
                        <el-radio :label="false">未完成</el-radio>
                     </el-radio-group>
                  </el-form-item>
               </el-form>
               <div slot="footer">
                  <el-button @click="editVisible = false">取 消</el-button>
                  <el-button type="primary" @click="handleUpdate">确 定</el-button>
               </div>
            </el-dialog>
         </el-main>
      </el-container>
      
   </div>
</template>

<style scoped></style>
