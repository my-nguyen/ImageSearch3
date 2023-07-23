package com.nguyen.imagesearch3

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val service: UnsplashService) {
}