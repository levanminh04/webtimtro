<template>
  <div>
    <!-- Breadcrumb -->

    <div class="container">
      <div class="row">
        <nav style="--bs-breadcrumb-divider: '>'" aria-label="breadcrumb">
          <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/search">Tìm Thuê</a></li>
            <li class="breadcrumb-item active" aria-current="page">Library</li>
          </ol>
        </nav>
      </div>
    </div>

    <!-- Page Content -->
    <div class="container">
      <div class="row">
        <!-- Main Content -->
        <div class="col-lg-8">
          <div class="main">
            <!-- Gallery -->
            <div
              id="carouselExampleDark"
              class="carousel carousel-dark slide"
              data-bs-ride="carousel"
            >
              <div class="carousel-indicators">
                <button
                  type="button"
                  data-bs-target="#carouselExampleDark"
                  data-bs-slide-to="0"
                  class="active"
                  aria-current="true"
                ></button>
                <button
                  type="button"
                  data-bs-target="#carouselExampleDark"
                  data-bs-slide-to="1"
                ></button>
                <button
                  type="button"
                  data-bs-target="#carouselExampleDark"
                  data-bs-slide-to="2"
                ></button>
              </div>
              <div class="carousel-inner">
                <div class="carousel-item active" data-bs-interval="10000">
                  <img
                    src="https://cloud.mogi.vn/images/2020/10/06/345/3617025d26e4481aa639847e9b6b62a3.jpg"
                    class="d-block w-100"
                    alt="Image 1"
                  />
                </div>
                <div class="carousel-item" data-bs-interval="2000">
                  <img
                    src="https://i.pinimg.com/736x/6c/d6/82/6cd682d354273462f797e79957423462.jpg"
                    class="d-block w-100"
                    alt="Image 2"
                  />
                </div>
                <div class="carousel-item">
                  <img
                    src="https://cloud.mogi.vn/images/2020/10/06/345/3617025d26e4481aa639847e9b6b62a3.jpg"
                    class="d-block w-100"
                    alt="Image 3"
                  />
                </div>
              </div>
              <button
                class="carousel-control-prev"
                type="button"
                data-bs-target="#carouselExampleDark"
                data-bs-slide="prev"
              >
                <span
                  class="carousel-control-prev-icon"
                  aria-hidden="true"
                ></span>
                <span class="visually-hidden">Previous</span>
              </button>
              <button
                class="carousel-control-next"
                type="button"
                data-bs-target="#carouselExampleDark"
                data-bs-slide="next"
              >
                <span
                  class="carousel-control-next-icon"
                  aria-hidden="true"
                ></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div>

            <!-- Article Header -->
            <div class="header-article my-4">
              <h1 class="fw-bold">
                Căn hộ mini, có gác full nội thất, siêu đẹp q7
              </h1>
              <p class="text-muted">
                Đường số 1, Phường Bình Thuận, Quận 7, TPHCM
              </p>
              <h2 class="text-danger fw-bold">5 triệu</h2>
            </div>

            <!-- Property Info -->
            <div class="property-info">
              <h2 class="fw-bold">Thông tin chính</h2>
              <div class="row g-3">
                <ul class="col-6 list-unstyled">
                  <li><strong>Giá:</strong> 5 triệu</li>
                  <li><strong>Diện tích sử dụng:</strong> 30 m<sup>2</sup></li>
                  <li><strong>Ngày đăng:</strong> 27/09/2020</li>
                  <li><strong>Mã BĐS:</strong> 20657824</li>
                </ul>
                <ul class="col-6 list-unstyled">
                  <li><strong>Phòng ngủ:</strong> 1</li>
                  <li><strong>Nhà tắm:</strong> 1</li>
                  <li><strong>Pháp lý:</strong> Không xác định</li>
                  <li><strong>Hướng:</strong> Không xác định</li>
                </ul>
              </div>
            </div>

            <!-- Description -->
            <div class="prop-info-content mt-4">
              <h2 class="fw-bold">Mô tả chi tiết</h2>
              <p>
                🌟 Vị trí ngay trung tâm Quận 7: gần sát Lotte Mart, SC ViVo, Đh
                Tôn Đức Thắng, Rmit... Chỉ 5p ra Quận 4, 10p qua Q1,Q5,Q8...
              </p>
              <p>🌟 Phòng mới tinh chưa ai ở.</p>
              <p>🌟 Đầy đủ tiện nghi, chỉ cần xách vali đến ở.</p>
            </div>
          </div>
        </div>

        <!-- Sidebar -->
        <div class="col-lg-4">
          <div class="side-bar">
            <!-- Agent Info -->
            <div class="agent-info bg-light p-3 rounded">
              <img
                src="https://mogi.vn/content/images/avatar.png"
                alt="Agent Avatar"
                class="img-thumbnail rounded-circle mb-3"
                style="width: 80px; height: 80px"
              />
              <h5>Trần Văn Hoàn</h5>
              <p class="text-muted mb-1">Đã tham gia: 1 năm 2 tháng</p>
              <a
                href="tel:0964341***"
                class="btn btn-primary btn-sm d-block my-2"
              >
                Gọi ngay
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Similar Properties -->
    <div class="SimilarUrl bg-light py-4">
      <div class="container">
        <h2 class="fw-bold mb-4">Bất động sản tương tự</h2>
        <div class="row g-3">
          <div class="col-6 col-md-4 col-lg-3">
            <div class="card">
              <img
                src="https://cloud.mogi.vn/images/thumb-small/2020/10/09/096/c343e80e8eb6412bb12bce1c63e33e20.jpg"
                class="card-img-top"
                alt="Property"
              />
              <div class="card-body">
                <h5 class="card-title text-danger">6 triệu 300 nghìn</h5>
                <p class="card-text">
                  <a href="#"
                    >Căn Hộ Gác Lững Tiện Nghi, PHAN XÍCH LONG - Gần CoopMart
                    Rạch Miêu</a
                  >
                </p>
              </div>
            </div>
          </div>
          <!-- Add more cards here -->
        </div>
      </div>
    </div>
  </div>
</template>
    
    <script>
export default {
  name: "Article",
};
</script>
    
    <style scoped>
.header-article h1 {
  font-size: 1.5rem;
}

.carousel-item img {
  height: 500px;
  object-fit: contain;
}
</style>
    