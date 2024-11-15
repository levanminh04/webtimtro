<template>
  <ul class="props">
    <li
      v-for="(motel, index) in motels"
      :key="index"
      style="background-color: #f3ebebc0"
    >
      <div class="prop-img">
        <img
          v-if="motel.filesDTO && motel.filesDTO.length > 0"
          class="lozad"
          :src="motel.filesDTO[0].fileUrl"
          alt="Image"
        />
        <span v-else> Không có hình ảnh</span>
      </div>
      <div class="prop-info">
        <h2 class="prop-title">
          <a class="link-overlay" @click="toArticlePage">{{
            motel.title || motel.detail
          }}</a>
        </h2>
        <div class="prop-addr">{{ motel.address }}</div>
        <ul class="prop-attr">
          <li>
            <i class="fa fa-chart-area"></i> {{ motel.area }} m<sup>2</sup>
          </li>
        </ul>
        <div class="price">{{ motel.price }} VND</div>
        <div class="prop-extra">
          <div class="prop-created">
            <span>Ngày Đăng:</span>
            <span>{{ motel.datePosted || "N/A" }}</span>
          </div>
          <div class="favorite">
            <ul>
              <li><i class="fas fa-phone-alt"></i></li>
              <li class="call-tlphone">
                SĐT: {{ motel.owner.phone || "N/A" }}
              </li>
              <li><i class="far fa-heart"></i></li>
            </ul>
          </div>
        </div>
      </div>
    </li>
  </ul>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      motels: [],
    };
  },
  mounted() {
    console.log("onMounted hook"); // Log khi component đã mount
    this.fetchMotels(); // Gọi hàm fetch dữ liệu
  },
  methods: {
    async fetchMotels() {
      try {
        const response = await axios.get("http://localhost:8081/dashboard");
        this.motels = response.data;
        console.log(response.data);
      } catch (error) {
        console.error("Lỗi khi lấy dữ liệu motel:", error);
      }
    },
  },
};
</script>
<style scoped>
.props {
  display: flex;
  flex-direction: column;
  gap: 16px; /* Khoảng cách giữa các mục */
}

.props li {
  display: flex;
  align-items: center;
  padding: 10px;
  border-radius: 8px;
}

.prop-img {
  width: 200px; /* Đặt kích thước cố định cho khung chứa ảnh */
  height: 150px;
  overflow: hidden;
  border-radius: 8px;
  margin-right: 16px; /* Khoảng cách giữa ảnh và phần thông tin */
}

.prop-img img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.prop-info {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.prop-title {
  font-size: 16px;
  font-weight: bold;
}

.prop-addr,
.prop-attr,
.price {
  margin: 4px 0;
}

.price {
  color: #00a65a;
  font-size: 18px;
  font-weight: bold;
}

.prop-extra {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 8px;
}
</style>