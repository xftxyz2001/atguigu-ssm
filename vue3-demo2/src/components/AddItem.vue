<script  setup type="module">
//引入store.js 

import { reactive } from 'vue'
import { useRouter } from 'vue-router'
import { addSchedule } from '../api/ScheduleApi'

//获取路由对象,编程路由
let rt = useRouter()

//定义展示标识和接收数据对象
const editForm = reactive({
    title: '',
    completed: false
})

async function addItem() {
    await addSchedule(editForm)
    rt.push('/')
}

function returnList() {
    rt.push('/')
}
</script>


<template>
    <div>
        <br>
        <br>

        <el-text class="mx-1" size="large" type="success">添加事项</el-text>

        <br>
        <br>
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
        <el-row>
            <el-button type="success" @click="addItem" round>添加</el-button>
            <el-button type="info" @click="returnList" round>返回</el-button>
        </el-row>
    </div>
</template>

<style  scoped></style>
