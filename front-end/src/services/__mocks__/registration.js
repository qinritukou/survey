export default {
  register (detail) {
    return new Promise((resolve, reject) => {
      detail.email === 'sunny@surverydemo.com'
        ? resolve({result: 'success'})
        : reject(new Error('User already exist'))
    })
  }
}
