using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using RazorPagesRental.Models;

namespace RazorPagesRental.Data
{
    public class RazorPagesRentalsContext : DbContext
    {
        public RazorPagesRentalsContext (DbContextOptions<RazorPagesRentalsContext> options)
            : base(options)
        {
        }

        public DbSet<RazorPagesRental.Models.Rentals> Rentals { get; set; } = default!;
    }
}
