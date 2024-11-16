<template>
  <div class="hpc-navbar">
    <div class="container">
      <div class="row">
        <navbarInforAccount />
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-2">
      <!-- Sidebar -->
      <div class="widget" style="background-color: #ecececc4">
        <ul class="list-group">
          <li class="list-group-item active">Thông tin Tài Khoản</li>
          <li class="list-group-item" style="cursor: pointer">Quản lý trọ đã đăng</li>
          <li class="list-group-item" style="cursor: pointer">Thông báo</li>
          <li class="list-group-item" style="cursor: pointer">
            Quản lý đánh giá trợ
          </li>
        </ul>
      </div>
    </div>

    <div class="col-md-8">
      <!-- Main Content -->
      <div class="widget" style="background-color: #ecececc4">
        <h3 class="mb-4">THÔNG TIN TÀI KHOẢN</h3>
        <p>
          Cập nhật thông tin của bạn và tìm hiểu các thông tin này được sử dụng
          ra sao.
        </p>

        <form @submit.prevent="updateInfo">
          <div class="mb-3">
            <label class="form-label">Họ tên</label>
            <input
              type="text"
              v-model="name"
              class="form-control"
              placeholder="Nhập Tên"
            />
          </div>
          <div class="mb-3">
            <label class="form-label">Số Điện Thoại</label>
            <input
              type="text"
              v-model="phoneNumber"
              class="form-control"
              placeholder="Nhập SĐT"
            />
          </div>

          <button type="submit" class="btn btn-primary">Cập nhật</button>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
import { ref } from "vue";
import navbarInforAccount from "@/components/PageComponents/inforAccountComponents/navbarInforAccount.vue";
export default {
  name: "UserProfile",
  components: {
    navbarInforAccount,
  },
  setup() {
    // Define reactive data properties
    const name = ref("Tuấn Nguyễn Quốc");
    const gender = ref("Nam");
    const birthdate = ref("");
    const phoneNumber = ref("0388112760");
    const idNumber = ref("");
    const address = ref("");

    // Define the method to handle form submission
    const updateInfo = () => {
      // Here, you would handle form submission, like sending the data to an API
      console.log("User Information:", {
        name: name.value,
        gender: gender.value,
        birthdate: birthdate.value,
        idNumber: idNumber.value,
        address: address.value,
      });
      alert("Cập nhật thông tin thành công!");
    };

    return {
      name,
      gender,
      birthdate,
      idNumber,
      address,
      updateInfo,
    };
  },
};
</script>
<style scoped>
.list-group-item.active {
  background-color: #323ff5;
  color: white;
  font-weight: bold;
}

h3 {
  color: #57bee7;
  font-size: xx-large;
}

button {
  background-color: #0056b3;
  border-color: #0056b3;
}
</style>
