<template>
  <div class="hpc-navbar">
    <div class="container">
      <div class="row">
        <navbarInforAccount></navbarInforAccount>
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
          <li class="list-group-item" style="cursor: pointer">
            Quản lý trọ đã đăng
          </li>
          <li
            class="list-group-item"
            @click="toPostPage"
            style="cursor: pointer"
          >
            Đăng Tin
          </li>
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
            <label class="form-label">Giới tính</label>
            <select v-model="gender" class="form-select">
              <option value="Nam">Nam</option>
              <option value="Nữ">Nữ</option>
              <option value="Khác"></option>
            </select>
          </div>

          <div class="mb-3">
            <label class="form-label">Ngày sinh</label>
            <input type="date" v-model="birthdate" class="form-control" />
          </div>

          <div class="mb-3">
            <label class="form-label">Mã số CCCD</label>
            <input
              type="text"
              v-model="idNumber"
              class="form-control"
              placeholder="Nhập mã số CCCD"
            />
          </div>

          <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <input
              type="text"
              v-model="address"
              class="form-control"
              placeholder="Nhập địa chỉ"
            />
          </div>

          <button type="submit" class="btn btn-primary">Cập nhật</button>
        </form>
      </div>
    </div>
  </div>


</template>
<script>
import { ref, onMounted } from "vue";
import navbarInforAccount from "@/components/PageComponents/accountPageComponents/navbarInforAccount.vue";
import axios from "axios";

export default {
  name: "InforAccount",
  components: {
    navbarInforAccount,
  },
  setup() {
    // Define reactive data properties
    // const name = ref("Tuấn Nguyễn Quốc");
    // const gender = ref("Nam");
    // const birthdate = ref("");
    // const phoneNumber = ref("0388112760");
    // const idNumber = ref("");
    // const address = ref("");
    const name = ref("");
    const gender = ref("");
    const birthdate = ref("");
    const idNumber = ref("");
    const address = ref("");
    const id = ref(""); 

    const fetchUserInfo = async () => {
      try {
        const token = localStorage.getItem("token");
        const response = await axios.get("http://localhost:8081/get-infor", {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });

        // Assign response data to form fields
        const userData = response.data;
        id.value = userData.id;
        name.value = userData.fullName;
        // Assuming gender and birthdate are present in the response
        gender.value = userData.gender || "";
        birthdate.value = userData.birthday || "";
        idNumber.value = userData.identificationnumber || "";
        address.value = userData.address || "";
      } catch (error) {
        console.error("Error fetching user info:", error);
      }
    };
    const updateInfo = async () => {
    try {
      const token = localStorage.getItem("token");
      const updatedData = {
        id: id.value,
        fullName: name.value,
        gender: gender.value,
        birthday: birthdate.value,
        identificationnumber: idNumber.value,
        address: address.value,
      };

      const response = await axios.put("http://localhost:8081/update-info", updatedData, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });

      if (response.status === 200) {
        alert("Cập nhật thông tin thành công!");
        // Sau khi cập nhật, bạn có thể gọi lại fetchUserInfo để cập nhật dữ liệu hiển thị
        fetchUserInfo();
      }
    } catch (error) {
      console.error("Error updating user info:", error);
      alert("Cập nhật thất bại!");
    }
  };
  onMounted(() => {
      fetchUserInfo();
    });

    return {
      name,
      gender,
      birthdate,
      idNumber,
      address,
      updateInfo,
    };

  },
  methods: {
    toPostPage() {
      this.$router.push("/account/dang-tin");
    },
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