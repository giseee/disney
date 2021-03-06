package com.alkemychallenge.disney.auth.controller;

import com.alkemychallenge.disney.auth.dto.AuthenticationRequest;
import com.alkemychallenge.disney.auth.dto.AuthenticationResponse;
import com.alkemychallenge.disney.auth.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserAuthContoller {
  private UserDetailsCustomService userDetailsCustomService;
  private AuthenticationManager authenticationManager;
  private JwtUtils jwtTokenUtil;
  @Autowired
    public UserAuthContoller(
            UserDetailsCustomService userDetailsCustomService,
            AuthenticationManager authenticationManager,
            JwtUtils jwtTokenUtil){
      this.userDetailsCustomService= userDetailsCustomService;
      this.authenticationManager= authenticationManager;
      this.jwtTokenUtil = jwtTokenUtil;
  }
  @PostMapping("/singup")
  public ResponseEntity<AuthenticationResponse> singUp(@Valid @RequestBody UserDto user) throws Exception{
          this.userDetailsCustomService.save(user);
          return ResponseEntity.status(HttpStatus.CREATED).build();
  }
  @PostMapping("/singin")
    public ResponseEntity<AuthenticationResponse> singIn(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
      UserDetails userDetails;
      try {
          Authentication auth = authenticationManager.authenticate(
                  new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
          );
          userDetails= (UserDetails) auth.getPrincipal();
       } catch (BadCredentialsException e){
          throw new Exception("Incorrect Username or Pasword",e);
      }
      final String jwt= jwtTokenUtil.generateToken(userDetails);
      return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }
}
