package com.example.WebTimTroBA.Service.Implement;

import com.example.WebTimTroBA.Converter.UserResponseConverter;
import com.example.WebTimTroBA.Model.DTO.UserDTO;
import com.example.WebTimTroBA.Model.Entity.RoleEntity;
import com.example.WebTimTroBA.Model.Entity.UserEntity;
import com.example.WebTimTroBA.Model.Response.MotelResponse;
import com.example.WebTimTroBA.Model.Response.UserResponse;
import com.example.WebTimTroBA.Repository.RoleRepository;
import com.example.WebTimTroBA.Repository.UserRepository;
import com.example.WebTimTroBA.Service.UserService;
import com.example.WebTimTroBA.Utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserResponseConverter userResponseConverter;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtils jwtTokenUtils;

    @Override
    public List<UserResponse> getAllUsers(Integer page) {
        Page<UserEntity> users = userRepository.findAll(PageRequest.of(page - 1, 3,
                Sort.by("created_at").descending().and(Sort.by("updated_at").descending()
                .and(Sort.by("username").ascending()))));
        return userResponseConverter.toUserResponse(users.getContent());
    }

    @Override
    public ResponseEntity<?> createUser(UserDTO user) {
        if (userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
            throw new DataIntegrityViolationException("Số Điện Thoại Đã Tồn Tại");
        }

        if (userRepository.existsByUserName(user.getUserName())) {
            throw new DataIntegrityViolationException("Tên Đăng Nhập Đã Tồn Tại");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DataIntegrityViolationException("Email Đã Tồn Tại");
        }

        if (!user.getPassword().equals(user.getRetypePassword())) {
            throw new DataIntegrityViolationException("Mật Khẩu Không Khớp");
        }
        RoleEntity roleEntity = roleRepository.findByRole("USER");
        UserEntity userEntity = UserEntity.builder().
                userName(user.getUserName())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .passWord(passwordEncoder.encode(user.getPassword()))
                .phoneNumber(user.getPhoneNumber())
                .build();
        userEntity.setRoleEntity(roleEntity);
        userRepository.save(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created user");
    }

    @Override
    public String login(String username, String password) throws Exception {
        Optional<UserEntity> user = userRepository.findByUserName(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Sai Tên Đăng Nhập Hoặc Mật Khẩu");
        }
        UserEntity userEntity = user.get();
        if (!passwordEncoder.matches(password, userEntity.getPassword())) {
            throw new BadCredentialsException("Sai Tên Đăng Nhập Hoặc Mật Khẩu");
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(username, password, userEntity.getAuthorities());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        return jwtTokenUtils.generateToken(userEntity);

    }

    @Override
    public Optional<UserEntity> findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public MotelResponse findMotelById(Integer id) {
        return null;
    }

    @Override
    public UserResponse getUserDetail(String token) {
        Integer id = jwtTokenUtils.extractUserId(token);
        UserEntity userEntity = userRepository.findById(id).get();
        return userResponseConverter.toUserResponse(userEntity);
    }
    @Override
    public UserEntity updateUserInfo(UserDTO userDTO) {
        // Tìm kiếm người dùng theo ID từ cơ sở dữ liệu
        Optional<UserEntity> optionalUser = userRepository.findById(userDTO.getId());

        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();

            // Cập nhật các field có trong UserDTO (các field không có trong JSON sẽ giữ nguyên giá trị hiện tại)
            if (userDTO.getFullName() != null) user.setFullName(userDTO.getFullName());
            if (userDTO.getEmail() != null) user.setEmail(userDTO.getEmail());
            if (userDTO.getPhoneNumber() != null) user.setPhoneNumber(userDTO.getPhoneNumber());
            if (userDTO.getUserName() != null) user.setUserName(userDTO.getUserName());
            if (userDTO.getAddress() != null) user.setAddress(userDTO.getAddress());
            if (userDTO.getIdentificationnumber() != null) user.setIdentificationnumber(userDTO.getIdentificationnumber());
            if (userDTO.getBirthday() != null) user.setBirthday(userDTO.getBirthday());
            if (userDTO.getGender() != null) user.setGender(userDTO.getGender());

            // Lưu lại các thay đổi
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with ID: " + userDTO.getId());
        }
    }
}
